package eu.javaland.clean_hexagonal_onion.query.publisher;

import eu.javaland.clean_hexagonal_onion.domaininteraction.publisher.PublisherDTO;
import eu.javaland.clean_hexagonal_onion.domaininteraction.publisher.PublisherFlow;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/publishers", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class PublisherQuery {

    PublisherFlow publisherFlow;

    @GetMapping
    public List<PublisherView> getPublishers(){
        return publisherFlow.getPublishers().stream().map(this::toView).toList();
    }

    private PublisherView toView(PublisherDTO publisherDTO){
        return new PublisherView(publisherDTO.id().toString(), publisherDTO.name());
    }
}
