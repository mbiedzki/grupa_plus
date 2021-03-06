package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByCompanyId(Long id);

    List<User> findUserByAdminIsTrue();

    List<User> findUserByHrIsTrue();

    User findUserByPesel(String pesel);
}
