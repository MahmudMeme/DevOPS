package mk.finki.ukim.mk.artefactid_lab.repostiory.inmemory;

import mk.finki.ukim.mk.artefactid_lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.artefactid_lab.model.Author;
import mk.finki.ukim.mk.artefactid_lab.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryAuthorRepository {
    public List<Author> findAll() {
        return DataHolder.authorList;
    }

    public Optional<Author> findById(long id) {
        return DataHolder.authorList.stream().filter(a -> a.getId() == id).findFirst();
    }


    public Author addBookToAuthor(Author author, Book book) {
        Optional<Author> author1 = findById(author.getId());
        author1.ifPresent(value -> value.getBookList().add(book));
        return author;
    }
}
