package eu.javaland.clean_hexagonal_onion.domain.book;

import eu.javaland.clean_hexagonal_onion.domain.DomainEvent;
import eu.javaland.clean_hexagonal_onion.domain.author.Author;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
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

    @Getter
    private final List<DomainEvent> domainEvents = new ArrayList<>();

    public static Book createManuscript(String title, Genre genre, Author author){
        return new Book(null,title,genre,null,false, null, author);
    }

    public void requestPublishing(UUID publisherId){
        this.publisherId = publisherId;
        domainEvents.add(new RequestPublishingEvent(this.id, this.publisherId));
    }

    public void updatePublishingInfo(String isbn) {
        this.isbn = isbn;
        this.published = true;
    }

    public boolean canBePublished() {
        return publisherId == null && !published;
    }

    @Value
    public static class RequestPublishingEvent extends DomainEvent {
        Long bookId;
        UUID publisherId;
    }
}
