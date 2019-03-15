package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Contract;
import pl.coderslab.repository.ContractRepository;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;

    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    public void delete(Long id) {
        contractRepository.delete(id);
    }

    public Contract findOne(Long id) {
        return contractRepository.findOne(id);
    }

    public List<Contract> findAll() { return contractRepository.findAll(); }

    public List<Contract> findContractsByInsuredId(Long id) {
        return contractRepository.findContractsByInsuredId(id);
    }

    /*public void printCertificate (String content) throws IOException {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.beginText();
        contentStream.showText(content);
        contentStream.endText();
        contentStream.close();
        document.save("certificate.pdf");
        document.close();
    }*/
}
