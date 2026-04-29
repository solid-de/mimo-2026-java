package edu.sorbonne.mimo.library.entities;

public record AuthorCreationRequest(String name,
                                    String country,
                                    String biography) {
}