package eu.javaland.clean_hexagonal_onion.domain.author;

import eu.javaland.clean_hexagonal_onion.data.author.Author;

public interface AuthorService {

    void registerAuthor(Author author);
}
