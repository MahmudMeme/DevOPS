package mk.finki.ukim.mk.artefactid_lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    String genre;

    int year;

    @ManyToMany
    @JoinTable(name = "booksAuthors")
    List<Author> authors;

    @ManyToOne
    BookStore bookStore;

    @OneToMany(mappedBy = "bookReview", fetch = FetchType.EAGER)
    List<Review> reviews;

    public Book() {
    }

    public Book(String title, String genre, int year, List<Author> authors, BookStore bookStore) {

        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = authors;
        this.bookStore = bookStore;
        reviews = new ArrayList<>();
    }

}
