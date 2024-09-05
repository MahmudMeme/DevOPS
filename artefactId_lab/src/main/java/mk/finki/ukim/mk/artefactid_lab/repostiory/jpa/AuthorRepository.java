package mk.finki.ukim.mk.artefactid_lab.repostiory.jpa;

import mk.finki.ukim.mk.artefactid_lab.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
