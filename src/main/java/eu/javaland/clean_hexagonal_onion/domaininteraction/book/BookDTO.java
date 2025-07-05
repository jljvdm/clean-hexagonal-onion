package eu.javaland.clean_hexagonal_onion.domaininteraction.book;

import eu.javaland.clean_hexagonal_onion.domain.book.Genre;
import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;

import java.util.UUID;


public record BookDTO(Long id, String title, Genre genre, String isbn,
                      UUID publisherId, boolean published, AuthorDTO author) {

    public static class Builder{
        private Long id;
        private String title;
        private Genre genre;
        private String isbn;
        private UUID publisherId;
        private boolean published;
        private AuthorDTO authorDTO;

        public BookDTO build(){
            return new BookDTO(id, title, genre, isbn, publisherId, published, authorDTO);
        }

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder genre(String genre){
            this.genre = Genre.valueOf(genre);
            return this;
        }

        public Builder isbn(String isbn){
            this.isbn = isbn;
            return this;
        }

        public Builder publisherId(UUID publisherId){
            this.publisherId = publisherId;
            return this;
        }

        public Builder published( boolean published ){
            this.published = published;
            return this;
        }

        public Builder author( AuthorDTO authorDTO){
            this.authorDTO = authorDTO;
            return this;
        }

    }

    public static Builder builder(){
        return new Builder();
    }

    public String genreString(){
        return genre.name();
    }
}
