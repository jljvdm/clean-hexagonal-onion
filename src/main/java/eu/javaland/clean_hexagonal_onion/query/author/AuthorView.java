package eu.javaland.clean_hexagonal_onion.query.author;

import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;

public record AuthorView(Long id, String name) {

    public AuthorView(AuthorDTO author) {
        this(author.id(), author.getFullName());
    }
}
