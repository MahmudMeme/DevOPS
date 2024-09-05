package mk.finki.ukim.mk.artefactid_lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.artefactid_lab.model.Author;
import mk.finki.ukim.mk.artefactid_lab.model.Book;
import mk.finki.ukim.mk.artefactid_lab.model.BookStore;
import mk.finki.ukim.mk.artefactid_lab.repostiory.jpa.AuthorRepository;
import mk.finki.ukim.mk.artefactid_lab.repostiory.jpa.BookRepository;
import mk.finki.ukim.mk.artefactid_lab.repostiory.jpa.BookStoreRepository;
import mk.finki.ukim.mk.artefactid_lab.service.AuthorService;
import mk.finki.ukim.mk.artefactid_lab.service.BookService;
import mk.finki.ukim.mk.artefactid_lab.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Author> authorList;
    public static List<Book> bookList;
    public static List<BookStore> bookStores;

    @Autowired
    public AuthorRepository authorRepository;

    @Autowired
    public BookStoreRepository bookStoreRepository;

    @Autowired
    public BookRepository bookRepository;

    @PostConstruct
    public void init() {

        authorList = new ArrayList<>();
        bookList = new ArrayList<>();
        bookStores = new ArrayList<>();

        if (bookStoreRepository.count() == 0) {

            bookStores.add(new BookStore("foto", "skopje", "skmk"));
            bookStores.add(new BookStore("coppy", "debar", "mkdb"));
            bookStores.add(new BookStore("well", "krivaPalanka", "kpmk"));
            bookStores.add(new BookStore("imeKnizara", "struga", "ssmk"));
            bookStores.add(new BookStore("sveIma", "skopje", "skmk2"));

            bookStoreRepository.saveAll(bookStores);
        }

        if (authorRepository.count() < 1) {

            authorList.add(new Author("Mahmud", "Memedovski", "student na finki", new ArrayList<>()));
            authorList.add(new Author("Veb", "Programiranje", "Tezek predmet", new ArrayList<>()));
            authorList.add(new Author("TestName", "TestSurname", "Test biography", new ArrayList<>()));
            authorList.add(new Author("Nekoj", "NeznamKoj", "mnogu jaka biografija", new ArrayList<>()));
            authorList.add(new Author("Kostantin", "Mishev", "Profesor na finki", new ArrayList<>()));

            authorRepository.saveAll(authorList);
        }

        if (bookRepository.count() < 1) {
            List<Author> authors = authorRepository.findAll();
            List<BookStore> stores = bookStoreRepository.findAll();

            bookList.add(new Book("maki's book", "code", 2023, new ArrayList<>(), stores.get(0)));
            bookList.add(new Book("kniga za veb P", "code", 2020, new ArrayList<>(), stores.get(2)));
            bookList.add(new Book("Biznis i menadzment", "biznis", 2018, new ArrayList<>(), stores.get(1)));
            bookList.add(new Book("Biznis sttistika", "math", 2021, new ArrayList<>(), stores.get(4)));
            bookList.add(new Book("test docker file", "math", 2021, new ArrayList<>(), stores.get(4)));

            bookRepository.saveAll(bookList);
        }

    }

}
