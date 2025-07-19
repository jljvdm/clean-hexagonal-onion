package eu.javaland.clean_hexagonal_onion.domaininteraction.book;


import java.util.List;

public interface BookDataService {

    void save(BookDTO bookDTO);

    List<BookDTO> findAllBooks();

    List<BookDTO> findAllBooksWithTitle(String title);

    BookDTO findById(long l);

    public class BookNotFoundException extends RuntimeException {
        public BookNotFoundException(String message) {
            super(message);
        }
    }
}
