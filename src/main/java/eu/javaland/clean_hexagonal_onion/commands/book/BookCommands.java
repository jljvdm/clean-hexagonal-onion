package eu.javaland.clean_hexagonal_onion.commands.book;

import eu.javaland.clean_hexagonal_onion.domaininteraction.publisher.PublisherFlow;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books/{id}/commands")
@AllArgsConstructor
@Slf4j
public class BookCommands {

    private final PublisherFlow publisherFlow;

    @PostMapping("/publish")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void publishBook(@PathVariable("id") Long bookId, @RequestBody PublishBookPayload publishBookPayload){
        publisherFlow.publishBook(bookId, publishBookPayload.publisherId());
    }
}
