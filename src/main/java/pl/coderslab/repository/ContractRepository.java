package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.model.Contract;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findContractsByInsuredId(Long id);

    List<Contract> findContractsByBeneficiaryId(Long id);

    List<Contract> findContractsByContractGroupId(Long id);

}
