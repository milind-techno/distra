package com.example.techjam.app2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @GetMapping("/app2")
    public String hello(){
        LOGGER.info("Inside /app2");
        return "Welcome to TechJam ";
    }
}
