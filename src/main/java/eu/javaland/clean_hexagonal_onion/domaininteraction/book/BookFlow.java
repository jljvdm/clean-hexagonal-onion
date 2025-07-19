package eu.javaland.clean_hexagonal_onion.domaininteraction.book;

import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorDataService;
import eu.javaland.clean_hexagonal_onion.domaininteraction.publisher.PublisherAppService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookFlow {

    private BookDataService bookDataService;

    private AuthorDataService authorDataService;

    private PublisherAppService publisherAppService;

    public List<BookDTO> findAllBooks(){
        return bookDataService.findAllBooks().stream().map(this::addAuthorToBook).toList();
    }

    public List<BookDTO> findAllBooksWithTitle(String title){
        return bookDataService.findAllBooksWithTitle(title).stream().map(this::addAuthorToBook).toList();
    }

    public void requestPublishingAtPublisher(UUID publisherId, Long bookId){
        var bookDTO = bookDataService.findById(bookId);
        var isbn = publisherAppService.requestPublishing(
                publisherId,
                bookDTO.author().getFullName(),
                bookDTO.title());

        var book = BookDomainMapper.toDomain(bookDTO);
        book.updatePublishingInfo(isbn);
        var updatedBookDTO = BookDomainMapper.toDTO(book);

        bookDataService.save(updatedBookDTO);
    }

    private BookDTO addAuthorToBook(BookDTO bookDTO){
        var authorDTO = authorDataService.findById(bookDTO.author().id());
        return BookDTO.builder()
                .id(bookDTO.id())
                .author(authorDTO)
                .genre(bookDTO.genre())
                .title(bookDTO.title())
                .isbn(bookDTO.isbn())
                .published(bookDTO.published())
                .publisherId(bookDTO.publisherId())
                .build();
    }
}
