package edu.sorbonne.mimo.library.service.impl;

import edu.sorbonne.mimo.library.model.Book;
import edu.sorbonne.mimo.library.model.BookCategory;
import edu.sorbonne.mimo.library.service.BookService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CsvBookService implements BookService {

    private final Map<String, Book> booksByIsbn;
    private final Map<BookCategory, List<Book>> booksByCategory;

    public CsvBookService() {
        Path path = Paths.get("files/books.csv");
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            throw new RuntimeException(e);
        }
        booksByIsbn = new HashMap<>();
        booksByCategory = new HashMap<>();
        for (String line : lines) {
            String[] split = line.split(",");
            if(split.length < 4) {
                System.out.println("Error parsing line: " + line);
                throw new IllegalArgumentException("A valid csv book must " +
                        "contain at least 4 columns");
            }
            String isbn = split[0];
            String title = split[1];
            String author = split[2];
            String rawCategory = split[3];
            BookCategory category;
            try {
                category = BookCategory.valueOf(rawCategory);
            } catch (IllegalArgumentException e) {
                System.out.println("Error parsing raw category: " + rawCategory);
                throw new IllegalArgumentException("Invalid category for line: " + line);
            }
            Book book = new Book(isbn, title, author, category);
            addBook(book);
        }
    }

    private void addBook(Book book) {
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
}
