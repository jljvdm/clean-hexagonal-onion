package eu.javaland.clean_hexagonal_onion.data.author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorJPA, Long> {
}
