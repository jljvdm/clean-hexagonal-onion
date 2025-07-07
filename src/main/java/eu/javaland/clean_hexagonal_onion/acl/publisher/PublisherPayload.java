package eu.javaland.clean_hexagonal_onion.acl.publisher;

import java.util.UUID;

public record PublisherPayload(String id, String name) {

    UUID getUUID(){
        return UUID.fromString(id);
    }
}
