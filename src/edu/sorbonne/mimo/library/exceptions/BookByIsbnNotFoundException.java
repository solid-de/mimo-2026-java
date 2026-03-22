package edu.sorbonne.mimo.library.exceptions;

public class BookByIsbnNotFoundException extends RuntimeException {

  public BookByIsbnNotFoundException(String isbn) {
    super(isbn);
  }

}
