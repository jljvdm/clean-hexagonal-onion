package eu.javaland.clean_hexagonal_onion.command.author;

import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorFlow;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors/commands")
@AllArgsConstructor
public class AuthorCommands {

    private AuthorFlow authorFlow;

    @PostMapping(value = "/register", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void create(@RequestBody RegisterAuthorDTO authorPayload) {
        authorFlow.registerAuthorByName(authorPayload.firstName(), authorPayload.lastName());
    }
}
