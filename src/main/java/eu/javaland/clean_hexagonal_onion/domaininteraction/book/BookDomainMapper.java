package eu.javaland.clean_hexagonal_onion.domaininteraction.book;

import eu.javaland.clean_hexagonal_onion.domain.book.Book;
import eu.javaland.clean_hexagonal_onion.domain.book.Genre;
import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorDomainMapper;

public class BookDomainMapper {

    public static BookDTO toDTO(Book book) {
        return new BookDTO(book.getId(), AuthorDomainMapper.mapToDTO(book.getAuthor()), book.getTitle(), book.getGenre().toString(), book.getPublisherId(), book.isPublished(), book.getIsbn(), book.getDomainEvents());
    }

    public static Book toDomain(BookDTO bookDTO) {
        return Book.restore()
                .id(bookDTO.id())
                .title(bookDTO.title())
                .author(AuthorDomainMapper.mapToDomain(bookDTO.author()))
                .genre(Genre.fromString(bookDTO.genre()))
                .published(bookDTO.published())
                .publisherId(bookDTO.publisherId())
                .isbn(bookDTO.isbn())
                .build();
    }
}
