package eu.javaland.clean_hexagonal_onion.domain.author;

import eu.javaland.clean_hexagonal_onion.domain.book.Book;
import eu.javaland.clean_hexagonal_onion.domain.book.Genre;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "restore")
public class Author {

    private Long id;
    private String firstName;
    private String lastName;


    private Author(Long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public static Author createAuthor(String firstName, String lastName){
        return new Author(null, firstName, lastName);
    }

    public Book writeManuscript(String title, Genre genre){
        return Book.createManuscript(title,genre,this);
    }
}
