package eu.javaland.clean_hexagonal_onion.data.author;

import lombok.Data;

@Data
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
}
