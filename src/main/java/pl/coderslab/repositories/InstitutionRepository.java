package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.models.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
