package eu.javaland.clean_hexagonal_onion.data.author;

import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorDTO;
import eu.javaland.clean_hexagonal_onion.domaininteraction.author.AuthorDataService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorDataService {

    private AuthorRepository authorRepository;

    @Override
    public void save(AuthorDTO author) {
        //  log.debug("Register Author met naam: {} {}", author.getFirstName(), author.getLastName());
        authorRepository.save(AuthorJPAMapper.mapToJPA(author));
    }

    @Override
    public List<AuthorDTO> findAll() {
        return authorRepository.findAll().stream().map(AuthorJPAMapper::mapToDTO).toList();
    }

    @Override
    public AuthorDTO findById(Long authorId) {
        return authorRepository.findById(authorId).map(AuthorJPAMapper::mapToDTO).orElse(null);
    }

    @Override
    public void registerAuthorByName(String firstName, String lastName) {

    }
}
