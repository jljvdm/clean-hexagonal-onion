package eu.javaland.clean_hexagonal_onion.domaininteraction.author;

import eu.javaland.clean_hexagonal_onion.domain.author.Author;

public class AuthorDomainMapper {
    public static Author mapToDomain(AuthorDTO input) {
        return Author.restore().id(input.id()).firstName(input.firstName()).lastName(input.lastName()).build();
    }

    public static AuthorDTO mapToDTO(Author author) {
        return AuthorDTO.builder().id(author.getId()).firstName(author.getFirstName()).lastName(author.getLastName()).build();
    }
}
