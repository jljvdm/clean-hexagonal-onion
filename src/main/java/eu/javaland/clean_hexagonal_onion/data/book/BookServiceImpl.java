package eu.javaland.clean_hexagonal_onion.data.book;

import eu.javaland.clean_hexagonal_onion.domaininteraction.book.BookDTO;
import eu.javaland.clean_hexagonal_onion.domaininteraction.book.BookDataService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BookServiceImpl implements BookDataService {

    BookRepository bookRepository;

    @Override
    public void save(BookDTO bookDTO) {
        bookRepository.save(BookJPAMapper.toJPA(bookDTO));
    }

    @Override
    public List<BookDTO> findAllBooks() {
        return bookRepository.findAll().stream().map(BookJPAMapper::toDTO).toList();
    }

    @Override
    public List<BookDTO> findAllBooksWithTitle(String title) {
        return bookRepository.findByTitleContaining(title).stream().map(BookJPAMapper::toDTO).toList();
    }
}
