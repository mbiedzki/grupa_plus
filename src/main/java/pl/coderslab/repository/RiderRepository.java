package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Rider;

public interface RiderRepository extends JpaRepository<Rider, Long> {
}
