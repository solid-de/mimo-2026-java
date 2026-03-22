package edu.sorbonne.mimo.library;

import edu.sorbonne.mimo.library.model.Book;
import edu.sorbonne.mimo.library.service.BookService;
import edu.sorbonne.mimo.library.service.impl.InMemoryBookService;

import java.util.Optional;

public class App {

    public static void main(String[] args) {
        System.out.println("Debut du programme");
        BookService bookService = new InMemoryBookService();
        Optional<Book> byIsbn = bookService.findByIsbn("9782070360024");

        byIsbn
                .map(book -> {
                    String title = book.title();
                    return title.toUpperCase();
                })
                .ifPresent(
                        titleUpperCase -> {
                            System.out.println("Livre trouve: " + titleUpperCase);
                            System.out.println("Livre trouve: " + titleUpperCase);
                        }
                );

        byIsbn.ifPresent(b -> System.out.println("Livre entier: " + b));

        System.out.println("Fin du programme");
    }

}
