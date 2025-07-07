package eu.javaland.clean_hexagonal_onion.domaininteraction.publisher;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PublisherFlow {

    PublisherAppService publisherAppService;

    public List<PublisherDTO> getPublishers() {
        return publisherAppService.getAllPublishers();
    }
}
