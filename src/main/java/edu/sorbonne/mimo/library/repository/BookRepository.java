package edu.sorbonne.mimo.library.repository;

import edu.sorbonne.mimo.library.entities.db.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, String> {

    Optional<BookEntity> findByIsbn(String isbn);

    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByBookCategory(String category);
}
