package mk.finki.ukim.mk.artefactid_lab.service;

import mk.finki.ukim.mk.artefactid_lab.model.BookStore;

import java.util.List;
import java.util.Optional;

public interface BookStoreService {
    public List<BookStore> findAll();
    public Optional<BookStore> findByName(String name);
    public Optional<BookStore> findById(Long id);
}
