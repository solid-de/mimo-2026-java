package edu.sorbonne.mimo.library.service.impl;

import edu.sorbonne.mimo.library.entities.Author;
import edu.sorbonne.mimo.library.entities.AuthorWriteRequest;
import edu.sorbonne.mimo.library.entities.db.AuthorEntity;
import edu.sorbonne.mimo.library.repository.AuthorRepository;
import edu.sorbonne.mimo.library.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DbAuthorService implements AuthorService {

    private static final Logger log = LoggerFactory.getLogger(DbAuthorService.class);
    private final AuthorRepository authorRepository;

    public DbAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional
    public Author create(AuthorWriteRequest request) {
        AuthorEntity entity = new AuthorEntity(
                request.name(),
                request.country(),
                request.biography());
        AuthorEntity saved = authorRepository.saveAndFlush(entity);
        log.debug("Created author: {}", saved.getId());
        return toRecord(saved);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id)
                .map(DbAuthorService::toRecord);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll()
                .stream()
                .map(DbAuthorService::toRecord)
                .toList();
    }

    @Override
    @Transactional
    public Author update(Long id, AuthorWriteRequest request) {
        AuthorEntity existing = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author not found: " + id));
        existing.setName(request.name());
        existing.setCountry(request.country());
        existing.setBiography(request.biography());
        authorRepository.saveAndFlush(existing);
        log.debug("Updated author: {}", id);
        return toRecord(existing);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            log.debug("Deleted author: {}", id);
            return true;
        }
        return false;
    }

    private static Author toRecord(AuthorEntity entity) {
        return new Author(entity.getId(), entity.getName(), entity.getCountry(), entity.getBiography());
    }
}