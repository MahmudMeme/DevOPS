package mk.finki.ukim.mk.artefactid_lab.repostiory.jpa;

import mk.finki.ukim.mk.artefactid_lab.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore, Long> {
    Optional<BookStore> findByName(String name);
}
