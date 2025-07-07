package eu.javaland.clean_hexagonal_onion.query.author;

import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorFlow;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AuthorQueries {

    AuthorFlow authorFlow;

    @GetMapping
    List<AuthorView> authorViews(){
        return authorFlow.getListOfAllAuthors().stream().map(AuthorView::new).toList();
    }
}
