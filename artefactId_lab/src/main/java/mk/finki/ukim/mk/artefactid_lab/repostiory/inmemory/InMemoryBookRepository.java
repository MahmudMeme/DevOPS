package mk.finki.ukim.mk.artefactid_lab.repostiory.inmemory;

import mk.finki.ukim.mk.artefactid_lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.artefactid_lab.model.Author;
import mk.finki.ukim.mk.artefactid_lab.model.Book;
import mk.finki.ukim.mk.artefactid_lab.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBookRepository {
    public List<Book> findAll() {
        return DataHolder.bookList;
    }

//    public Optional<Book> findByIsbn(String isbn) {
//        return DataHolder.bookList.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();
//    }
//
//    public Author addAuthorToBook(Author author, Book book) {
//        Optional<Book> bookBase = findByIsbn(book.getIsbn());
//        if (bookBase.isPresent()) {
//            book.getAuthors().add(author);
//        } else {
//            book.getAuthors().add(author);
//            DataHolder.bookList.add(book);
//        }
//        return author;
//    }
//
//    public Optional<Book> editBook(Book book, String isbn, String title, String ganre, Integer year, BookStore bookStore, Author id) {
//        Optional<Book> bookBase = findByIsbn(book.getIsbn());
//        if (bookBase.isPresent()) {
//            book.setIsbn(isbn);
//            book.setTitle(title);
//            book.setYear(year);
//            book.setGenre(ganre);
//            book.getBookStores().add(bookStore);
//            //book.setBookStore(bookStore);
//            book.getAuthors().add(id);
//            bookBase = Optional.of(book);
//            return bookBase;
//        } else {
//            book.setIsbn(isbn);
//            book.setTitle(title);
//            book.setYear(year);
//            book.setGenre(ganre);
//            book.getBookStores().add(bookStore);
//            //book.setBookStore(bookStore);
//            book.getAuthors().add(id);
//            DataHolder.bookList.add(book);
//            return Optional.of(book);
//        }
//    }
//
//    public void deleteByIsbn(String isbn) {
//        DataHolder.bookList.removeIf(b -> b.getIsbn().equals(isbn));
//    }

    public Book addBook(Book book) {
        DataHolder.bookList.add(book);
        return book;
    }

    public void copyBook(Book book) {
        DataHolder.bookList.add(book);
    }
}
