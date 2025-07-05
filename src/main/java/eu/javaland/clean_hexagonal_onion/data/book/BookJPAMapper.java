package eu.javaland.clean_hexagonal_onion.data.book;

import eu.javaland.clean_hexagonal_onion.data.author.AuthorJPAMapper;
import eu.javaland.clean_hexagonal_onion.domaininteraction.book.BookDTO;

public class BookJPAMapper {

    public static BookJPA toJPA(BookDTO bookDTO) {
        return BookJPA.builder()
                .id(bookDTO.id())
                .isbn(bookDTO.isbn())
                .publisherId(bookDTO.publisherId())
                .published(bookDTO.published())
                .author(AuthorJPAMapper.mapToJPA(bookDTO.author()))
                .title(bookDTO.title())
                .genre(bookDTO.genreString())
                .build();
    }

    public static BookDTO toDTO(BookJPA bookJPA) {
        return BookDTO.builder()
                .id(bookJPA.getId())
                .isbn(bookJPA.getIsbn())
                .publisherId(bookJPA.getPublisherId())
                .published(bookJPA.isPublished())
                .author(AuthorJPAMapper.mapToDTO(bookJPA.getAuthor()))
                .title(bookJPA.getTitle())
                .genre(bookJPA.getGenre())
                .build();
    }

}
