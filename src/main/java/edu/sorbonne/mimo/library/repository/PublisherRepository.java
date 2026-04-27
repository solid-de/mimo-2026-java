package edu.sorbonne.mimo.library.repository;

import edu.sorbonne.mimo.library.entities.db.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {

    Optional<PublisherEntity> findByName(String name);
}