package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.models.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT SUM(quantity) FROM donations", nativeQuery = true)
    Integer sumOfBags();

    @Query(value = "SELECT COUNT(*) FROM donations", nativeQuery = true)
    Integer sumOfDonations();
}
