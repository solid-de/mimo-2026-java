package edu.sorbonne.mimo.library.controller;

import edu.sorbonne.mimo.library.entities.Book;
import edu.sorbonne.mimo.library.service.BookService;
import edu.sorbonne.mimo.library.service.impl.CsvBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final static Logger log = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn) {
        log.debug("Received request to get Book for ISBN '{}'", isbn);
        Book book = bookService.findByIsbn(isbn)
                .orElse(null);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);

    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        log.debug("Creating book {}", book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping(value ="/books")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
}
