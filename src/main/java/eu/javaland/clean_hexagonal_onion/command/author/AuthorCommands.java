package eu.javaland.clean_hexagonal_onion.command.author;

import eu.javaland.clean_hexagonal_onion.domain.author.Author;
import eu.javaland.clean_hexagonal_onion.domain.author.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors/commands")
@AllArgsConstructor
public class AuthorCommands {

    private AuthorService authorService;

    @PostMapping(value = "/register", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void create(@RequestBody RegisterAuthorDTO authorPayload){
        authorService.registerAuthor(Author.createAuthor(authorPayload.firstName(), authorPayload.lastName()));
    }
}
