package eu.javaland.clean_hexagonal_onion.data.book;

import eu.javaland.clean_hexagonal_onion.data.author.AuthorJPA;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
@Getter
public class BookJPA {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "book_seq_gen")
    @SequenceGenerator(name = "book_seq_gen", sequenceName = "book_seq", allocationSize = 1)
    private Long id;

    private String title;

    private String genre;

    private String isbn;

    private UUID publisherId;

    private boolean published;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private AuthorJPA author;

}
