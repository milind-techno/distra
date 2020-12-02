package com.example.techjam.app1;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class App1Application {

    public static void main(String[] args) {
        ElasticApmAttacher.attach();
        SpringApplication.run(App1Application.class, args);
    }

}
