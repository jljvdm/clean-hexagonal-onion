package eu.javaland.clean_hexagonal_onion.data.author;

import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;

public class AuthorJPAMapper {
    public static AuthorJPA mapToJPA(AuthorDTO input) {
        return new AuthorJPA(input.id(), input.firstName(), input.lastName());
    }

    public static AuthorDTO mapToDTO(AuthorJPA input){
        return new AuthorDTO(input.getId(), input.getFirstName(), input.getLastName());
    }
}
