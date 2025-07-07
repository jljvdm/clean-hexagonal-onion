package eu.javaland.clean_hexagonal_onion.query.book;

import eu.javaland.clean_hexagonal_onion.domaininteraction.book.BookDTO;
import eu.javaland.clean_hexagonal_onion.domaininteraction.book.BookFlow;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BookQueries {

    BookFlow bookFlow;

    @GetMapping
    List<BookView> findBooks(@RequestParam(value = "title", required = false) String title){
        if ( title == null || title.isBlank()) {
            return bookFlow.findAllBooks().stream().map(this::convertToView).toList();
        } else {
            return bookFlow.findAllBooksWithTitle(title).stream().map(this::convertToView).toList();
        }
    }

    private BookView convertToView(BookDTO bookDTO){
        return new BookView(bookDTO.title(), bookDTO.genreString(), bookDTO.author().getFullName());
    }

}
