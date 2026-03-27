package edu.sorbonne.mimo.library.service;


import edu.sorbonne.mimo.library.entities.Book;
import edu.sorbonne.mimo.library.entities.BookCategory;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findByIsbn(String isbn);


    List<Book> findByCategory(BookCategory category);

}
