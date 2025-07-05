package eu.javaland.clean_hexagonal_onion.data.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookJPA, UUID> {

    List<BookJPA> findByTitleContaining(String title);
}
