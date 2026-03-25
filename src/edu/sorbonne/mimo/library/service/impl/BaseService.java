package edu.sorbonne.mimo.library.service.impl;

import edu.sorbonne.mimo.library.model.Book;
import edu.sorbonne.mimo.library.model.BookCategory;
import edu.sorbonne.mimo.library.service.BookService;

import java.util.*;

public class BaseService implements BookService {

    private final Map<String, Book> booksByIsbn;
    private final Map<BookCategory, List<Book>> booksByCategory;
    public BaseService() {
        booksByIsbn = new HashMap<>();
        booksByCategory = new HashMap<>();

    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(booksByIsbn.values());
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        Book book = booksByIsbn.get(isbn);
        return Optional.ofNullable(book);
    }

    @Override
    public List<Book> findByCategory(BookCategory category) {
        return booksByCategory.getOrDefault(category, List.of());
    }

    protected void addBook(Book book) {
        booksByIsbn.put(book.isbn(), book);
        List<Book> categoryBooks = booksByCategory.get(book.bookCategory());
        if(categoryBooks == null) {
            categoryBooks = new ArrayList<>();
            categoryBooks.add(book);
            booksByCategory.put(book.bookCategory(), categoryBooks);
        } else {
            categoryBooks.add(book);
        }
    }
}
