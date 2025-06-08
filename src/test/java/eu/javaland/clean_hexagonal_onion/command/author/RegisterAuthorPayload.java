package eu.javaland.clean_hexagonal_onion.command.author;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterAuthorPayload {

    private String firstName;

    private String lastName;

}
