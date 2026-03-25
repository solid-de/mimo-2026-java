package edu.sorbonne.mimo.library.service.impl;

import edu.sorbonne.mimo.library.model.Book;
import edu.sorbonne.mimo.library.model.BookCategory;

public class InMemoryBookService extends BaseService {

    public InMemoryBookService() {
        Book firstBook   = new Book("9782070429158", "Harry Potter à l'école des sorciers", "J.K. Rowling", BookCategory.Fiction);
        Book secondBook  = new Book("9782253151241", "Jean Moulin : Biographie", " Laure Moulin", BookCategory.Biography);
        Book thirdBook   = new Book("9782070612758", "Le Petit Prince", "Antoine de Saint-Exupéry", BookCategory.Fiction);
        Book fourthBook  = new Book("9780451524935", "1984", "George Orwell", BookCategory.Fiction);
        Book fithBook    = new Book("9782226257017", "Sapiens : Une brève histoire de l'humanité", "Yuval Noah Harari", BookCategory.History);
        Book sixthBook   = new Book("9782070360024", "L'Étranger", "Albert Camus", BookCategory.NonFiction);
        Book seventhBook = new Book("9782221002247", "Dune", "Frank Herbert", BookCategory.SciFi);
        Book eighthBook  = new Book("9782253006329", "Une étude en rouge", "Arthur Conan Doyle", BookCategory.Fiction);
        Book ninethBook  = new Book("9780857197689", "Atomic Habits", "James Clear", BookCategory.NonFiction);
        Book tenthBook   = new Book("9782266154116", "Le Seigneur des Anneaux", "J.R.R. Tolkien", BookCategory.Fiction);
        Book eleventhBook= new Book("9782844140586", "Persépolis", "Marjane Satrapi", BookCategory.Fiction);
        Book twelfthBook = new Book("9782081238626", "Une brève histoire du temps", "Stephen Hawking", BookCategory.Science);

        addBook(firstBook);
        addBook(secondBook);
        addBook(thirdBook);
        addBook(fourthBook);
        addBook(fithBook);
        addBook(sixthBook);
        addBook(seventhBook);
        addBook(eighthBook);
        addBook(ninethBook);
        addBook(tenthBook);
        addBook(eleventhBook);
        addBook(twelfthBook);

    }
}
