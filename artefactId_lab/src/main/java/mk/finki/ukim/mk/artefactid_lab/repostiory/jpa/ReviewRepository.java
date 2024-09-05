package mk.finki.ukim.mk.artefactid_lab.repostiory.jpa;

import mk.finki.ukim.mk.artefactid_lab.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByTimestampBetween(LocalDateTime startDate, LocalDateTime endDate);
}
