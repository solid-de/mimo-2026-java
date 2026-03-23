package edu.sorbonne.mimo.library.service.impl;

import edu.sorbonne.mimo.library.model.Book;
import edu.sorbonne.mimo.library.model.BookCategory;
import edu.sorbonne.mimo.library.service.BookService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CsvBookService implements BookService {

    private final Map<String, Book> booksByIsbn;
    private final Map<BookCategory, List<Book>> booksByCategory;
    public CsvBookService() {

    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return Optional.empty();
    }

    @Override
    public List<Book> findByCategory(BookCategory category) {
        return List.of();
    }
}
