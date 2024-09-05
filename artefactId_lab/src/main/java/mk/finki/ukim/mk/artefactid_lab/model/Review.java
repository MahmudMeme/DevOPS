package mk.finki.ukim.mk.artefactid_lab.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score;

    private String description;
    @ManyToOne
    private Book bookReview;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public Review() {
    }

    public Review(Integer score, String description, Book book, LocalDateTime timestamp) {
        this.score = score;
        this.description = description;
        this.bookReview = book;
        this.timestamp = timestamp;
    }
}
