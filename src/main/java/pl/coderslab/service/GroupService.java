package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Contract;
import pl.coderslab.model.Group;
import pl.coderslab.repository.ContractRepository;
import pl.coderslab.repository.GroupRepository;

import java.util.List;

@Service
@Transactional
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ContractRepository contractRepository;

    public void save(Group group) {
        groupRepository.save(group);
    }

    public void delete(Long id) {
        groupRepository.delete(id);
    }

    public Group findOne(Long id) {
        return groupRepository.findOne(id);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public boolean noContractsWithContractGroupId(Long id) {
        List<Contract> contracts = contractRepository.findContractsByContractGroupId(id);
        return contracts.isEmpty();
    }
}
