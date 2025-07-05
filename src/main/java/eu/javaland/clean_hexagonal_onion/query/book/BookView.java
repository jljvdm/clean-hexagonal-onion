package eu.javaland.clean_hexagonal_onion.query.book;

import eu.javaland.clean_hexagonal_onion.domaininteraction.book.BookDTO;

public record BookView(
        String title,
        String genre,
        String authorName
) {
    public BookView(BookDTO bookDTO){
        this(bookDTO.title(), bookDTO.genreString(), bookDTO.author().getFullName());
    }
}
