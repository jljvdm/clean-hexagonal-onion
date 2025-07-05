package eu.javaland.clean_hexagonal_onion.domaininteraction.book;

import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorDataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookFlow {

    private BookDataService bookDataService;

    private AuthorDataService authorDataService;

    public List<BookDTO> findAllBooks(){
        return bookDataService.findAllBooks().stream().map(this::addAuthorToBook).toList();
    }

    public List<BookDTO> findAllBooksWithTitle(String title){
        return bookDataService.findAllBooksWithTitle(title).stream().map(this::addAuthorToBook).toList();
    }

    private BookDTO addAuthorToBook(BookDTO bookDTO){
        var authorDTO = authorDataService.findById(bookDTO.author().id());
        return BookDTO.builder()
                .id(bookDTO.id())
                .author(authorDTO)
                .genre(bookDTO.genre().name())
                .title(bookDTO.title())
                .isbn(bookDTO.isbn())
                .published(bookDTO.published())
                .publisherId(bookDTO.publisherId())
                .build();
    }
}
