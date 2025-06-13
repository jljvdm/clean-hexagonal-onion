package eu.javaland.clean_hexagonal_onion.query;

import eu.javaland.clean_hexagonal_onion.domain.author.Author;

public record AuthorView(Long id, String name) {

    public AuthorView(Author author) {
        this(author.getId(), author.getFullName());
    }
}
