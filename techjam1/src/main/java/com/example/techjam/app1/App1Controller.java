package com.example.techjam.app1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class App1Controller {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(App1Controller.class);


    @GetMapping("/app1")
    public String hello(){
        LOGGER.info(" Inside /app1");
        return restTemplate.getForObject("http://localhost:8081/app2", String.class);
    }

    @NewSpan("MyCreateResponse")
    private String createResponse() {
        return restTemplate.getForObject("http://localhost:8081/app2", String.class);
    }
}
