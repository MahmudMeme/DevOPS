package mk.finki.ukim.mk.artefactid_lab.repostiory.inmemory;

import mk.finki.ukim.mk.artefactid_lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.artefactid_lab.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBookStoreRepository {
    public List<BookStore> findAll() {
        return DataHolder.bookStores;
    }

    public Optional<BookStore> findByName(String name) {
        return DataHolder.bookStores.stream().filter(n -> n.getName().equals(name)).findFirst();
    }

    public Optional<BookStore> findById(Long id) {
        return DataHolder.bookStores.stream().filter(n -> n.getId().equals(id)).findFirst();
    }
}
