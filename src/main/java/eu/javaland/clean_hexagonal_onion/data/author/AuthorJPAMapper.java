package eu.javaland.clean_hexagonal_onion.data.author;

import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;

public class AuthorJPAMapper {
    public static AuthorJPA mapToJPA(AuthorDTO authorDTO) {
        return new AuthorJPA(authorDTO.id(), authorDTO.firstName(), authorDTO.lastName());
    }

    public static AuthorDTO mapToDTO(AuthorJPA authorJPA){
        return new AuthorDTO(authorJPA.getId(), authorJPA.getFirstName(), authorJPA.getLastName());
    }
}
