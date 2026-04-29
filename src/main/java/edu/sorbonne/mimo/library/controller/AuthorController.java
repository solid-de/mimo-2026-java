package edu.sorbonne.mimo.library.controller;

import edu.sorbonne.mimo.library.entities.Author;
import edu.sorbonne.mimo.library.entities.AuthorCreationRequest;
import edu.sorbonne.mimo.library.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private static final Logger log = LoggerFactory.getLogger(AuthorController.class);
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        return authorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorCreationRequest request) {
        Author created = authorService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id,
                                               @RequestBody AuthorCreationRequest request) {
        try {
            Author updated = authorService.update(id, request);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        boolean deleted = authorService.deleteById(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}