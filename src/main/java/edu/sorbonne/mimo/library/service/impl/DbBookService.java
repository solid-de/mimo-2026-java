package edu.sorbonne.mimo.library.service.impl;

import edu.sorbonne.mimo.library.entities.Book;
import edu.sorbonne.mimo.library.entities.BookCategory;
import edu.sorbonne.mimo.library.repository.BookRepository;
import edu.sorbonne.mimo.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbBookService implements BookService {

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
}
