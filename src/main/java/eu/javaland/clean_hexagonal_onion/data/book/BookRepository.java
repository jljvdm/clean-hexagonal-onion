package eu.javaland.clean_hexagonal_onion.data.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookJPA, Long> {

    List<BookJPA> findByTitleContaining(String title);
}
