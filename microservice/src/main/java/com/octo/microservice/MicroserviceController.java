package com.octo.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroserviceController {

    private final Environment environment;

    @Autowired
    public MicroserviceController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from the microservice running on the port: " + environment.getProperty("local.server.port");
    }
}
