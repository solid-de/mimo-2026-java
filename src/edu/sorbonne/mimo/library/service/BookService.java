package edu.sorbonne.mimo.library.service;

import edu.sorbonne.mimo.library.exceptions.BookByIsbnNotFoundException;
import edu.sorbonne.mimo.library.model.Book;
import edu.sorbonne.mimo.library.model.BookCategory;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findByIsbn(String isbn);


    List<Book> findByCategory(BookCategory category);

}
