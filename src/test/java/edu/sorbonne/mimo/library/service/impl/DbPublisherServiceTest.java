package edu.sorbonne.mimo.library.service.impl;

import edu.sorbonne.mimo.library.entities.Publisher;
import edu.sorbonne.mimo.library.entities.PublisherWriteRequest;
import edu.sorbonne.mimo.library.entities.db.PublisherEntity;
import edu.sorbonne.mimo.library.repository.PublisherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DbPublisherServiceTest {

    @Mock
    private PublisherRepository publisherRepository;
    @InjectMocks
    private DbPublisherService publisherService;

    private final PublisherEntity gallimard = new PublisherEntity("Gallimard", "France");

    // ----------------- create -----------------

    @Test
    void create_NewPublisher_Success() {
        PublisherWriteRequest request = new PublisherWriteRequest("NewPub", "UK");
        when(publisherRepository.findByName("NewPub")).thenReturn(Optional.empty());
        when(publisherRepository.saveAndFlush(any())).thenReturn(
                new PublisherEntity("NewPub", "UK"));
        Publisher result = publisherService.create(request);
        assertEquals("NewPub", result.name());
        verify(publisherRepository).saveAndFlush(any());
    }

    @Test
    void create_Duplicate_Throws() {
        when(publisherRepository.findByName("Gallimard"))
                .thenReturn(Optional.of(gallimard));
        PublisherWriteRequest request = new PublisherWriteRequest("Gallimard", "France");
        assertThrows(IllegalArgumentException.class, () -> publisherService.create(request));
        verify(publisherRepository, never()).saveAndFlush(any());
    }

    // ----------------- findById -----------------

    @Test
    void findById_Found_ReturnsPublisher() {
        gallimard.setId(1L);
        when(publisherRepository.findById(1L)).thenReturn(Optional.of(gallimard));
        Optional<Publisher> result = publisherService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals("Gallimard", result.get().name());
    }

    @Test
    void findById_NotFound_ReturnsEmpty() {
        when(publisherRepository.findById(99L)).thenReturn(Optional.empty());
        assertTrue(publisherService.findById(99L).isEmpty());
    }

    // ----------------- findAll -----------------

    @Test
    void findAll_ReturnsAll() {
        when(publisherRepository.findAll()).thenReturn(List.of(gallimard));
        List<Publisher> list = publisherService.findAll();
        assertEquals(1, list.size());
    }

    // ----------------- update -----------------

    @Test
    void update_Existing_Success() {
        gallimard.setId(1L);
        when(publisherRepository.findById(1L)).thenReturn(Optional.of(gallimard));
        when(publisherRepository.saveAndFlush(any())).thenReturn(gallimard);
        PublisherWriteRequest request = new PublisherWriteRequest("Gallimard Editions", "FR");
        Publisher updated = publisherService.update(1L, request);
        assertEquals("Gallimard Editions", updated.name());
        assertEquals("FR", updated.country());
    }

    @Test
    void update_NotFound_Throws() {
        when(publisherRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class,
                () -> publisherService.update(99L, new PublisherWriteRequest("n", "c")));
    }

    // ----------------- delete -----------------

    @Test
    void deleteById_Exists_ReturnsTrue() {
        when(publisherRepository.existsById(1L)).thenReturn(true);
        assertTrue(publisherService.deleteById(1L));
        verify(publisherRepository).deleteById(1L);
    }

    @Test
    void deleteById_NotExists_ReturnsFalse() {
        when(publisherRepository.existsById(99L)).thenReturn(false);
        assertFalse(publisherService.deleteById(99L));
        verify(publisherRepository, never()).deleteById(any());
    }
}