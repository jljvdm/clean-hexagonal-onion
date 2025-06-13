package eu.javaland.clean_hexagonal_onion.data.author;

import eu.javaland.clean_hexagonal_onion.domain.author.Author;
import eu.javaland.clean_hexagonal_onion.domain.author.AuthorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Override
    public void registerAuthor(Author author) {
      //  log.debug("Register Author met naam: {} {}", author.getFirstName(), author.getLastName());
        authorRepository.save(AuthorMapper.mapToJPA(author));
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll().stream().map(AuthorMapper::mapToDomain).toList();
    }
}
