package mk.finki.ukim.mk.artefactid_lab.service.impl;

import mk.finki.ukim.mk.artefactid_lab.model.Book;
import mk.finki.ukim.mk.artefactid_lab.model.Review;
import mk.finki.ukim.mk.artefactid_lab.repostiory.jpa.BookRepository;
import mk.finki.ukim.mk.artefactid_lab.repostiory.jpa.ReviewRepository;
import mk.finki.ukim.mk.artefactid_lab.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveReview(Integer score, String description, Book book, LocalDateTime timestamp) {
        Review review = new Review(score, description, book, timestamp);
        reviewRepository.save(review);
        book.getReviews().add(review);
    }

    @Override
    public List<Review> findAllByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return reviewRepository.findAllByTimestampBetween(startDate,endDate);
    }
}
