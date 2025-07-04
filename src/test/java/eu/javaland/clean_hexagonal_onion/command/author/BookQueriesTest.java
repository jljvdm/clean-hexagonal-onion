package eu.javaland.clean_hexagonal_onion.command.author;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.javaland.clean_hexagonal_onion.data.author.AuthorJPA;
import eu.javaland.clean_hexagonal_onion.data.book.BookJPA;
import eu.javaland.clean_hexagonal_onion.query.book.BookView;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class BookQueriesTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    void beforeEach() {
        entityManager.createNativeQuery("DELETE FROM author where true; DELETE FROM book where true;")
                .executeUpdate();
    }

    @Test
    @Transactional
    void shouldFindBooksWithNoQueryParam() throws Exception {
        // given
        entityManager.createNativeQuery(
                        "INSERT INTO author (id, first_name, last_name) VALUES (?,?,?)")
                .setParameter(1, 1)
                .setParameter(2, "firstName")
                .setParameter(3, "lastName")
                .executeUpdate();
        var book1 = BookJPA.builder()
                .author(AuthorJPA.builder().id(1L).build())
                .genre("HORROR")
                .title("horror-book")
                .build();
        var book2 = BookJPA.builder()
                .author(AuthorJPA.builder().id(1L).build())
                .genre("ROMANCE")
                .title("romance-book")
                .build();
        var expectedBookView1 = new BookView("horror-book", "HORROR", "firstName lastName");
        var expectedBookView2 = new BookView("romance-book", "ROMANCE", "firstName lastName");

        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.flush();
        // when
        MvcResult result = mockMvc.perform(get("/books")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        // then
        var resultingBookViews = objectMapper.readValue(
                result.getResponse().getContentAsString(), new TypeReference<List<BookView>>() {
                });
        assertThat(resultingBookViews).hasSize(2);
        assertThat(resultingBookViews).usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .containsExactlyInAnyOrder(expectedBookView1, expectedBookView2);
    }

    @Test
    @Transactional
    void shouldFindBooksFilteredByQueryParamTitle() throws Exception {
        // given
        entityManager.createNativeQuery(
                        "INSERT INTO author (id, first_name, last_name) VALUES (?,?,?)")
                .setParameter(1, 1)
                .setParameter(2, "firstName")
                .setParameter(3, "lastName")
                .executeUpdate();
        var book1 = BookJPA.builder()
                .author(AuthorJPA.builder().id(1L).build())
                .genre("HORROR")
                .title("horror-book")
                .build();
        var book2 = BookJPA.builder()
                .author(AuthorJPA.builder().id(1L).build())
                .genre("ROMANCE")
                .title("romance-book")
                .build();
        var expectedBookView = new BookView("horror-book", "HORROR", "firstName lastName");

        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.flush();
        // when
        MvcResult result = mockMvc.perform(get("/books")
                        .accept(MediaType.APPLICATION_JSON)
                        .queryParam("title", "orror-"))
                .andExpect(status().isOk())
                .andReturn();
        // then
        var resultingBookViews = objectMapper.readValue(
                result.getResponse().getContentAsString(), new TypeReference<List<BookView>>() { });
        assertThat(resultingBookViews).hasSize(1);
        assertThat(resultingBookViews).usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
                .containsExactly(expectedBookView);
    }
}