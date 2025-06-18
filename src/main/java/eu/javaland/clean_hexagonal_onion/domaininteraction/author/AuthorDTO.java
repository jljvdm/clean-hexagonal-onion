package eu.javaland.clean_hexagonal_onion.domaininteraction.author;

import lombok.Builder;

@Builder
public record AuthorDTO(Long id, String firstName, String lastName) {
    public String getFullName(){
        return "%s %s".formatted(firstName, lastName);
    }
}
