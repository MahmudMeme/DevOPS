package mk.finki.ukim.mk.artefactid_lab.service.impl;

import mk.finki.ukim.mk.artefactid_lab.model.Author;
import mk.finki.ukim.mk.artefactid_lab.model.Book;
import mk.finki.ukim.mk.artefactid_lab.model.BookStore;
import mk.finki.ukim.mk.artefactid_lab.model.exception.NotFundSomethingException;
import mk.finki.ukim.mk.artefactid_lab.repostiory.inmemory.InMemoryAuthorRepository;
import mk.finki.ukim.mk.artefactid_lab.repostiory.inmemory.InMemoryBookRepository;
import mk.finki.ukim.mk.artefactid_lab.repostiory.inmemory.InMemoryBookStoreRepository;
import mk.finki.ukim.mk.artefactid_lab.repostiory.jpa.AuthorRepository;
import mk.finki.ukim.mk.artefactid_lab.repostiory.jpa.BookRepository;
import mk.finki.ukim.mk.artefactid_lab.repostiory.jpa.BookStoreRepository;
import mk.finki.ukim.mk.artefactid_lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService/*, AuthorService*/ {
    private final BookRepository memoryBookRepository;
    private final AuthorRepository authorRepository;
    private final BookStoreRepository bookStoreRepository;

    public BookServiceImpl(BookRepository memoryBookRepository,
                           AuthorRepository authorRepository,
                           BookStoreRepository bookStoreRepository) {
        this.memoryBookRepository = memoryBookRepository;
        this.authorRepository = authorRepository;
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<Book> listBooks() {
        return memoryBookRepository.findAll();
    }

    @Override
    public Author addAuthorToBook(Long authorId, Long id) {
        if (authorId == null || id == null) {
            throw new IllegalArgumentException();
        }
        Optional<Book> book = memoryBookRepository.findById(id);
        Optional<Author> author = authorRepository.findById(authorId);
        if (book.isPresent() && author.isPresent()) {
            book.get().getAuthors().add(author.get());
            memoryBookRepository.save(book.get());
            return author.get();
        }
        return null;
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return memoryBookRepository.findById(id);
    }

    @Override
    public Book editBook(Long id, String title, String ganre, Integer year, Long bookStoreId, Long authorId) {

//        Optional<Book> book = memoryBookRepository.findById(id);
        //      Optional<Author> author = authorRepository.findById(authorId);
        //    Optional<BookStore> bookStore = bookStoreRepository.findById(bookStoreId);
        Author author1 = authorRepository.findById(authorId).orElseThrow(NotFundSomethingException::new);
        BookStore bookStore1 = bookStoreRepository.findById(bookStoreId).orElseThrow(NotFundSomethingException::new);
        Book book1 = memoryBookRepository.findById(id).orElseThrow(NotFundSomethingException::new);
//        if (book.isEmpty() || author.isEmpty() || bookStore.isPresent()) {
//            System.out.println("greska vo edit service delot");
//            throw new IllegalArgumentException();
//        }
//        Book b = book.get();
//        b.setTitle(title);
//        b.setYear(year);
//        b.setGenre(ganre);
//        b.getAuthors().add(author.get());
//        b.setBookStore(bookStore.get());
//        //b.getBookStores().add(bookStore.get());
        book1.setTitle(title);
        book1.setYear(year);
        book1.setGenre(ganre);

        book1.setBookStore(bookStore1);
        //b.getBookStores().add(bookStore.get());
        memoryBookRepository.save(book1);
        book1.getAuthors().add(author1);
        return book1;
    }

    @Override
    public Book addBook(String title, String ganre, Integer year, Long bookStoreId, Long authorId) {

        // Optional<Author> author = authorRepository.findById(authorId);
        Author author1 = authorRepository.findById(authorId).orElseThrow(NotFundSomethingException::new);
        // Optional<BookStore> bookStore = bookStoreRepository.findById(bookStoreId);
        BookStore bookStore1 = bookStoreRepository.findById(bookStoreId).orElseThrow(NotFundSomethingException::new);

//        if (author.isPresent() && bookStore.isPresent()) {
//            Book book = new Book(title, ganre, year, new ArrayList<>(), bookStore.get());
//            book.getAuthors().add(author.get());
//            // book.getBookStores().add(bookStore.get());
//            memoryBookRepository.save(book);
//            return book;
//        }
//        return null;

        Book book = new Book(title, ganre, year, new ArrayList<>(), bookStore1);
        memoryBookRepository.save(book);
        book.getAuthors().add(author1);
        return book;
    }

    @Override
    public void deleteByIsbn(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        memoryBookRepository.deleteById(id);
    }

    @Override
    public void copyBook(Long id) {
        Book book=memoryBookRepository.findById(id).orElseThrow(NotFundSomethingException::new);
        BookStore b=bookStoreRepository.findById(book.getBookStore().getId()).get();
        Book bookCopy = new Book( book.getTitle(), book.getGenre(),book.getYear(),new ArrayList<>(),b);
        bookCopy.setId(book.getId() + 1000);
        List<Author> authorList = book.getAuthors();
        memoryBookRepository.save(bookCopy);
        bookCopy.getAuthors().addAll(authorList);

    }

}
