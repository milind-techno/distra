package com.example.techjam.app1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class App1Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(App1Controller.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private App1Service service;

    @GetMapping("/app1")
    public String app1(){
        LOGGER.info("Inside /app1");
        return restTemplate.getForObject("http://localhost:8081/app2", String.class);
    }

    @GetMapping("/app1/wait")
    public String app1Wait(){
        LOGGER.info("Inside /app1/wait");
        try {
            service.dummyMethodWithNoTracing();
            service.dummyMethodWithTracing();
        } catch (InterruptedException e) {
            LOGGER.error("Problem while waiting", e);
        }
        return restTemplate.getForObject("http://localhost:8081/app2", String.class);
    }

    @GetMapping("/app1/exception")
    public String app1Exception() {
        LOGGER.info("Inside /app1/exception");
        throw new IllegalStateException("You shouldn't be here");
    }


}
