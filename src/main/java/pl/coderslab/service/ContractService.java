package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Contract;
import pl.coderslab.repository.ContractRepository;

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
}
