package edu.sorbonne.mimo.library.service.impl;

import edu.sorbonne.mimo.library.model.Book;
import edu.sorbonne.mimo.library.model.BookCategory;
import edu.sorbonne.mimo.library.service.BookService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CsvBookService extends BaseService {

    public CsvBookService() {
        Path path = Paths.get("files/books.csv");
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            throw new RuntimeException(e);
        }
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


}
