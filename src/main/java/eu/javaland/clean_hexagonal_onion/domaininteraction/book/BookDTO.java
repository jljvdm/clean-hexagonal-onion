package eu.javaland.clean_hexagonal_onion.domaininteraction.book;

import eu.javaland.clean_hexagonal_onion.domain.DomainEvent;
import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public record BookDTO(Long id, AuthorDTO author, String title, String genre, UUID publisherId, boolean published, String isbn,  List<DomainEvent> domainEvents
) {

    public boolean isPublished() {
        return published();
    }

    public static class Builder{
        private Long id;
        private String title;
        private String genre;
        private String isbn;
        private UUID publisherId;
        private boolean published;
        private AuthorDTO authorDTO;
        private List<DomainEvent> domainEvents;

        public BookDTO build(){
            domainEvents = new ArrayList<>();
            return new BookDTO(id, authorDTO, title, genre, publisherId, published, isbn, domainEvents);
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
            this.genre = genre;
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

        public Builder domainEvents(ArrayList<DomainEvent> domainEvents){
            this.domainEvents = domainEvents;
            return this;
        }

    }

    public static Builder builder(){
        return new Builder();
    }

}
