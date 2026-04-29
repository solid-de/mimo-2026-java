package edu.sorbonne.mimo.library.service;

import edu.sorbonne.mimo.library.entities.Author;
import edu.sorbonne.mimo.library.entities.AuthorCreationRequest;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author create(AuthorCreationRequest request);

    Optional<Author> findById(Long id);

    List<Author> findAll();

    Author update(Long id, AuthorCreationRequest request);

    boolean deleteById(Long id);
}