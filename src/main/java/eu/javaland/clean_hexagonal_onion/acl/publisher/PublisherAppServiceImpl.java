package eu.javaland.clean_hexagonal_onion.acl.publisher;

import eu.javaland.clean_hexagonal_onion.domaininteraction.publisher.PublisherAppService;
import eu.javaland.clean_hexagonal_onion.domaininteraction.publisher.PublisherDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class PublisherAppServiceImpl implements PublisherAppService {

    private static final String SUB_PATH_PUBLISHERS = "/publishers";

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${publisher.service.host}")
    private String publisherServiceBaseUri;


    @Override
    public List<PublisherDTO> getAllPublishers() {
        var result =  restTemplate.getForObject(publisherServiceBaseUri + "/publishers", PublisherPayload[].class);

        return Arrays.stream(Objects.requireNonNull(result)).map(payLoad -> new PublisherDTO(payLoad.getUUID(), payLoad.name())).toList();
    }
}
