package mk.finki.ukim.mk.artefactid_lab.service;

import mk.finki.ukim.mk.artefactid_lab.model.Author;
import mk.finki.ukim.mk.artefactid_lab.model.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAuthors();

    Author findById(Long id);

    public Optional<Book> findBookForAuthor(Long id);
    public Author addBookToAuthor(Long authorId, Long id);

}
