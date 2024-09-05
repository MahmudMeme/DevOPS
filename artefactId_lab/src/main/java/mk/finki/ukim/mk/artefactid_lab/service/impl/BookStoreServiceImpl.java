package mk.finki.ukim.mk.artefactid_lab.service.impl;

import mk.finki.ukim.mk.artefactid_lab.model.BookStore;
import mk.finki.ukim.mk.artefactid_lab.repostiory.jpa.BookStoreRepository;
import mk.finki.ukim.mk.artefactid_lab.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookStoreServiceImpl implements BookStoreService {
    private final BookStoreRepository bookStoreRepository;

    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }

    @Override
    public Optional<BookStore> findByName(String name) {
        return bookStoreRepository.findByName(name);
    }

    @Override
    public Optional<BookStore> findById(Long id) {
        return bookStoreRepository.findById(id);
    }
}
