package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.MainCover;

public interface MainCoverRepository extends JpaRepository<MainCover, Long> {
}
