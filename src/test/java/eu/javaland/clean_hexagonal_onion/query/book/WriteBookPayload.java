package eu.javaland.clean_hexagonal_onion.query.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class WriteBookPayload {

    private String title;

    private String genre;

}
