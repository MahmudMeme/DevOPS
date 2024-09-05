package mk.finki.ukim.mk.artefactid_lab.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
////////////
import mk.finki.ukim.mk.artefactid_lab.model.converotrs.AuthorDullNameConverter;


import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Convert(converter = AuthorDullNameConverter.class)
    private AuthorFullName fullname;

    String biography;

    @ManyToMany
//    @JoinTable(name = "booksAuthors")
    List<Book> bookList;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    public Author() {
    }

    public Author(String name, String surname, String biography, List<Book> bookList) {
        this.fullname = new AuthorFullName(name, surname);
        this.biography = biography;
        this.bookList = bookList;
    }
    public Author(Long id,String name, String surname, String biography, List<Book> bookList) {
        this.id=id;
        this.fullname = new AuthorFullName(name, surname);
        this.biography = biography;
        this.bookList = bookList;
    }
}
