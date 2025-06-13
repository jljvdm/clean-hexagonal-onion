package eu.javaland.clean_hexagonal_onion.data.author;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
@Getter
public class AuthorJPA {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "author_seq_gen")
    @SequenceGenerator(name = "author_seq_gen", sequenceName = "author_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
}
