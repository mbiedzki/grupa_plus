package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Company;


public interface CompanyRepository extends JpaRepository<Company, Long> {
}
