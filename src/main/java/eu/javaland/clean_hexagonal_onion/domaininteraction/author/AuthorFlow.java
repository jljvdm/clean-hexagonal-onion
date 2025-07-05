package eu.javaland.clean_hexagonal_onion.domaininteraction.author;

import eu.javaland.clean_hexagonal_onion.domain.author.Author;
import eu.javaland.clean_hexagonal_onion.domain.book.Genre;
import eu.javaland.clean_hexagonal_onion.domaininteraction.book.BookDataService;
import eu.javaland.clean_hexagonal_onion.domaininteraction.book.BookDomainMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorFlow {

    private AuthorDataService authorDataService;

    private BookDataService bookDataService;

    public void registerAuthorByName(String firstName, String lastName) {
        authorDataService.save(AuthorDomainMapper.mapToDTO(Author.createAuthor(firstName, lastName)));
    }

    public List<AuthorDTO> getListOfAllAuthors() {
        return authorDataService.findAll();
    }

   public AuthorDTO findById(Long authorId){
        return authorDataService.findById(authorId);
   }

    public void registerBook(Long authorId, String title, String genre) {
        var author = AuthorDomainMapper.mapToDomain(authorDataService.findById(authorId));
        var book = author.writeManuscript(title, Genre.valueOf(genre));
        bookDataService.save(BookDomainMapper.toDTO(book));
    }
}
