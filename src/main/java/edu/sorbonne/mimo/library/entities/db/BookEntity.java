package edu.sorbonne.mimo.library.entities.db;

import edu.sorbonne.mimo.library.entities.Book;
import edu.sorbonne.mimo.library.entities.BookCategory;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "category")
    private String bookCategory;

    public BookEntity() {
    }

    public BookEntity(String isbn, String title, String author, String bookCategory) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.bookCategory = bookCategory;
    }

    // Getters and setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Book toRecord() {
        BookCategory category;
        try {
            category = BookCategory.valueOf(bookCategory);
        } catch (IllegalArgumentException e) {
            System.out.println("Error parsing raw category: " + bookCategory);
            throw new IllegalArgumentException("Invalid category for row: " + this.isbn);
        }
        return new Book(isbn, title, author, category);
    }

    public static BookEntity fromRecord(Book book) {
        String rawCategory = Optional.ofNullable(book.bookCategory())
                .map(c -> c.name())
                .orElse(null);
        return new BookEntity(book.isbn(), book.title(), book.author(), rawCategory);
    }
}
