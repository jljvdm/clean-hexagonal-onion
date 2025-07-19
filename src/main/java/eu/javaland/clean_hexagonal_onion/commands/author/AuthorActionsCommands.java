package eu.javaland.clean_hexagonal_onion.commands.author;

import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorFlow;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors/{authorId}/commands")
@AllArgsConstructor
public class AuthorActionsCommands {

    private AuthorFlow authorFlow;

    @PostMapping(value = "/writeBook")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void writeBook(@RequestBody RegisterBookPayLoad book, @PathVariable("authorId") Long authorId){
        authorFlow.registerBook(authorId, book.title(), book.genre());
    }

}
