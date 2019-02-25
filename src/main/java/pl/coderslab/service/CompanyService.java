package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Address;
import pl.coderslab.model.Company;
import pl.coderslab.model.User;
import pl.coderslab.repository.CompanyRepository;
import pl.coderslab.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private UserRepository userRepository;

    public void save(Company company) {
        companyRepository.save(company);
    }

    public void delete(Long id) {
        companyRepository.delete(id);
    }

    public Company findOne(Long id) {
        return companyRepository.findOne(id);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public boolean noUsersInCompany(Long id) {
        List<User> users = userRepository.findUserByCompanyId(id);
        if (!users.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
