package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Contract;
import pl.coderslab.model.User;
import pl.coderslab.repository.ContractRepository;
import pl.coderslab.repository.UserRepository;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContractRepository contractRepository;

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

    public User findUserByPesel(String pesel) {return userRepository.findUserByPesel(pesel);}


    public boolean noContractsWithInsuredId(Long id) {
        List<Contract> contracts = contractRepository.findContractsByInsuredId(id);
        if (!contracts.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    public boolean noContractsWithBeneficiaryId(Long id) {
        List<Contract> contracts = contractRepository.findContractsByBeneficiaryId(id);
        if (!contracts.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }


}
