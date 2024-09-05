package mk.finki.ukim.mk.artefactid_lab.repostiory.jpa;

import mk.finki.ukim.mk.artefactid_lab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
