package eu.javaland.clean_hexagonal_onion.query;

import eu.javaland.clean_hexagonal_onion.domain.author.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/authors", produces = "application/json")
@AllArgsConstructor
public class AuthorQueries {

    AuthorService authorService;

    @GetMapping
    List<AuthorView> authorViews(){
        return authorService.getAll().stream().map(AuthorView::new).toList();
    }
}
