package mk.finki.ukim.mk.artefactid_lab.service;

import mk.finki.ukim.mk.artefactid_lab.model.Book;
import mk.finki.ukim.mk.artefactid_lab.model.Review;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewService {
    void saveReview(Integer score, String description, Book book, LocalDateTime timestamp);
    List<Review> findAllByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);
}
