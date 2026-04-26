package edu.sorbonne.mimo.library.service.impl;

import edu.sorbonne.mimo.library.controller.BookController;
import edu.sorbonne.mimo.library.entities.Book;
import edu.sorbonne.mimo.library.entities.BookCategory;
import edu.sorbonne.mimo.library.entities.db.BookEntity;
import edu.sorbonne.mimo.library.repository.BookRepository;
import edu.sorbonne.mimo.library.service.BookService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbBookService implements BookService {

    private final static Logger log = LoggerFactory.getLogger(DbBookService.class);


    private final BookRepository bookRepository;

    public DbBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll().stream()
                .map(bookEntity -> bookEntity.toRecord())
                .toList();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .map(bookEntity -> bookEntity.toRecord());
    }

    @Override
    public List<Book> findByCategory(BookCategory category) {
        return bookRepository.findByBookCategory(category.name())
                .stream()
                .map(bookEntity -> bookEntity.toRecord())
                .toList();
    }

    @Override
    @Transactional
    public void create(Book book) {
        BookEntity bookEntity = BookEntity.fromRecord(book);
        bookRepository.save(bookEntity);
        log.debug("Created new book: {}", bookEntity.toRecord());
        if(book.isbn().endsWith("2758")) {
            throw new RuntimeException("Book already exists");
        }
    }
}
