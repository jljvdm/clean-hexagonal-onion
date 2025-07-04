package eu.javaland.clean_hexagonal_onion.domaininteraction.author;

import eu.javaland.clean_hexagonal_onion.domain.author.Author;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorDomainMapperTest {

    @Test
    void mapToDomain() {
        // given
        var input = new AuthorDTO(1L, "first", "last");
        var expectedOutput = Author.restore()
                .id(1L)
                .firstName("first")
                .lastName("last")
                .build();
        // when
        var result = AuthorDomainMapper.mapToDomain(input);
        // then
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedOutput);
    }
}
