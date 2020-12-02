package com.example.techjam.app1;

import co.elastic.apm.api.Traced;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class App1Service {
    private final Random random = new Random();

    public void dummyMethodWithNoTracing() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
    }

    @Traced(subtype = "dummy-method", action = "wait-for-random-time")
    public void dummyMethodWithTracing() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
    }

}
