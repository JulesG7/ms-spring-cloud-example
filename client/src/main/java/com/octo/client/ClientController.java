package com.octo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    private final RestTemplate restTemplate;

    @Autowired
    public ClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String callMicroservice() {
        return restTemplate.getForObject(ClientConfiguration.MICROSERVICE_SERVICE_URL + "/hello", String.class);
    }
}
