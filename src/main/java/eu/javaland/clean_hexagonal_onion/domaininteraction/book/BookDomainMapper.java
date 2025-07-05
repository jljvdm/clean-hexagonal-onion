package eu.javaland.clean_hexagonal_onion.domaininteraction.book;

import eu.javaland.clean_hexagonal_onion.domain.book.Book;
import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorDomainMapper;

public class BookDomainMapper {

    public static BookDTO toDTO(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getGenre(), book.getIsbn(), book.getPublisherId(), book.isPublished(), AuthorDomainMapper.mapToDTO(book.getAuthor()));
    }
}
