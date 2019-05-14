package nl.sogeti.cloudcontractconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProducerService {

    private final RestTemplate restTemplate;

    private int port = 6565;

    @Autowired
    public ProducerService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    String getGreetingFromProducer() {

        HttpHeaders headers = new HttpHeaders();

        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

//        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/greeting",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class);
        return response.getBody();
    }

}
