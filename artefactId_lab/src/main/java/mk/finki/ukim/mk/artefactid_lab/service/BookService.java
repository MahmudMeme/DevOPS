package mk.finki.ukim.mk.artefactid_lab.service;

import mk.finki.ukim.mk.artefactid_lab.model.Author;
import mk.finki.ukim.mk.artefactid_lab.model.Book;
import mk.finki.ukim.mk.artefactid_lab.model.BookStore;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listBooks();

    Author addAuthorToBook(Long authorId, Long id);

    Optional<Book> findBookById(Long id);

    Book editBook(Long id, String title, String ganre, Integer year, Long bookStoreId, Long authorId);
    Book addBook(String title, String ganre, Integer year, Long bookStore, Long authorId);
    void deleteByIsbn(Long id);
    void copyBook(Long id);


}
