package mk.finki.ukim.mk.artefactid_lab.service.impl;

import mk.finki.ukim.mk.artefactid_lab.model.Author;
import mk.finki.ukim.mk.artefactid_lab.model.Book;
import mk.finki.ukim.mk.artefactid_lab.repostiory.jpa.AuthorRepository;
import mk.finki.ukim.mk.artefactid_lab.repostiory.jpa.BookRepository;
import mk.finki.ukim.mk.artefactid_lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository memoryBookRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, BookRepository memoryBookRepository) {
        this.authorRepository = authorRepository;
        this.memoryBookRepository = memoryBookRepository;
    }

    @Override
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return authorRepository.findById(id).orElseThrow();
    }

    @Override
    public Optional<Book> findBookForAuthor(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return memoryBookRepository.findById(id);
    }

    @Override
    public Author addBookToAuthor(Long authorId, Long id) {
        if (authorId == null ) {
            throw new IllegalArgumentException();
        }
        Optional<Book> book = findBookForAuthor(id);
        Optional<Author> author = authorRepository.findById(authorId);

        if (author.isPresent() && book.isPresent()) {
            author.get().getBookList().add(book.get());
            return author.get();
            //return authorRepository.addBookToAuthor(author.get(),book.get());
        } else {
            return null;
        }
    }
}
