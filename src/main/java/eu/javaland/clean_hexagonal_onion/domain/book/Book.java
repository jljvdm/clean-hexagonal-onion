package eu.javaland.clean_hexagonal_onion.domain.book;

import eu.javaland.clean_hexagonal_onion.domain.author.Author;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder(builderMethodName = "restore")
public class Book {

    private Long id;
    private String title;
    private Genre genre;
    private UUID publisherId;
    private boolean published;
    private String isbn;
    private Author author;

    public static Book createManuscript(String title, Genre genre, Author author){
        return new Book(null,title,genre,null,false, null, author);
    }
}
