package edu.sorbonne.mimo.library.service.impl;


import edu.sorbonne.mimo.library.entities.Book;
import edu.sorbonne.mimo.library.entities.BookCategory;

public class InMemoryBookService extends BaseService {

    public InMemoryBookService() {
        Book firstBook   = new Book("9782070429158", "Harry Potter à l'école des sorciers", "J.K. Rowling", BookCategory.Fiction);
        Book secondBook  = new Book("9782253151241", "Jean Moulin : Biographie", " Laure Moulin", BookCategory.Biography);
        Book thirdBook   = new Book("9782070612758", "Le Petit Prince", "Antoine de Saint-Exupéry", BookCategory.Fiction);


        addBook(firstBook);
        addBook(secondBook);
        addBook(thirdBook);


    }
}
