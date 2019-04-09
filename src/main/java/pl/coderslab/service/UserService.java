package pl.coderslab.service;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Contract;
import pl.coderslab.model.User;
import pl.coderslab.repository.ContractRepository;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.util.BCrypt;
import pl.coderslab.util.PdfCreator;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ContractService contractService;

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public List<User> findAllAdmins() {
        return userRepository.findUserByAdminIsTrue();
    }

    public List<User> findAllHrs() {
        return userRepository.findUserByHrIsTrue();
    }

    public User findUserByPesel(String pesel) {
        return userRepository.findUserByPesel(pesel);
    }


    public boolean noContractsWithInsuredId(Long id) {
        List<Contract> contracts = contractRepository.findContractsByInsuredId(id);
        return contracts.isEmpty();
    }

    public boolean noContractsWithBeneficiaryId(Long id) {
        List<Contract> contracts = contractRepository.findContractsByBeneficiaryId(id);
        return contracts.isEmpty();
    }

    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void buildPdf(Long userId) throws IOException, DocumentException {

        User userToSend = userService.findOne(userId);
        List<Contract> contracts = contractService.findContractsByInsuredId(userId);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><body>");
        stringBuilder.append("<img src='/usr/local/bin/grupaplus/logosmall.jpg'></img>");
        stringBuilder.append("<p>Podsumowanie umów ubezpieczenia:</p><hr></hr>");
        stringBuilder.append("<p>Ubezpieczony: " + userToSend.getFullName() + "</p>");
        stringBuilder.append("<p>PESEL: " + userToSend.getPesel() + "</p>");
        stringBuilder.append("<p>Telefon: " + userToSend.getPhone() + "</p>");
        stringBuilder.append("<p>Email: " + userToSend.getEmail() + "</p>");

        for (Contract contract : contracts) {
            stringBuilder.append("<hr></hr>");
            stringBuilder.append(
                    "<p>"
                            + "Umowa nr: " + contract.getId() + ",  "
                            + "Grupa: " + contract.getContractGroup().getName() + ",  "
                            + "Zakład pracy: " + contract.getContractGroup().getCompany().getName()
                            + "</p>"
                            + "<p>"
                            + "Uposażony: " + contract.getBeneficiary()+ ",  "
                            + "Produkt: " + contract.getContractGroup().getProduct().getName()
                            + "</p>"
                            + "<p>"
                            + "Umowa główna ubezpieczenia: " + contract.getContractGroup()
                            .getProduct().getMainCover().getName() + ",  "
                            + "Suma ubezpieczenia: " + contract.getContractGroup()
                            .getProduct().getMainCover().getSumAssured()
                            + "</p>");
        }

        stringBuilder.append("</body></html>");
        PdfCreator.pdfCreate(stringBuilder.toString());

    }


}
