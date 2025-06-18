package eu.javaland.clean_hexagonal_onion.domaininteraction.author;

import eu.javaland.clean_hexagonal_onion.domain.author.Author;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorFlow {

    private AuthorDataService authorDataService;

    public void registerAuthorByName(String firstName, String lastName) {
        authorDataService.save(AuthorDomainMapper.mapToDTO(Author.createAuthor(firstName, lastName)));
    }

    public List<AuthorDTO> getListOfAllAuthors() {
        return authorDataService.findAll();
    }
}
