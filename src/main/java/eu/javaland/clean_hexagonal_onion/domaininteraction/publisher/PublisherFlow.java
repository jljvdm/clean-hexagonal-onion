package eu.javaland.clean_hexagonal_onion.domaininteraction.publisher;

import eu.javaland.clean_hexagonal_onion.domain.book.Book;
import eu.javaland.clean_hexagonal_onion.domaininteraction.book.BookDataService;
import eu.javaland.clean_hexagonal_onion.domaininteraction.book.BookDomainMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherFlow {

    PublisherAppService publisherAppService;

    BookDataService bookDataService;

    public List<PublisherDTO> getPublishers() {
        return publisherAppService.getAllPublishers();
    }

    public void publishBook(long bookId, String publisherId) {
        var publisherDTO = publisherAppService.getPublisherById(publisherId);
        var bookDTO = bookDataService.findById(bookId);
        Book book = BookDomainMapper.toDomain(bookDTO);
        if (! book.canBePublished()){

            throw new BookAlreadyInPublishingException("Book already in publishing");
        }
        book.requestPublishing(publisherDTO.id());
        bookDataService.save(BookDomainMapper.toDTO(book));
    }

    public static class BookAlreadyInPublishingException extends RuntimeException {
        public BookAlreadyInPublishingException(String errorMessage){
            super(errorMessage);
        }
    }
}
