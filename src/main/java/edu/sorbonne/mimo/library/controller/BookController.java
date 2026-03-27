package edu.sorbonne.mimo.library.controller;

import edu.sorbonne.mimo.library.entities.Book;
import edu.sorbonne.mimo.library.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{isbn}")
    public Book getBook(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn)
                .orElse(null);

    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
}
