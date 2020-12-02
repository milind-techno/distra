package com.example.techjam.app1;

import co.elastic.apm.api.CaptureTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class App1Scheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(App1Scheduler.class);

    @Autowired
    private App1Service service;

    @Scheduled(fixedDelay = 60000)
    public void dummyScheduleWithNoTracing() {
        LOGGER.info("Running dummyScheduleWithNoTracing");
        try {
            service.dummyMethodWithNoTracing();
        } catch (InterruptedException e) {
            LOGGER.error("Problem with scheduler not waiting", e);
        }
    }

    @Scheduled(fixedDelay = 60000)
    @CaptureTransaction(type = "scheduled")
    public void dummyScheduleWithCaptureTransaction() {
        LOGGER.info("Running dummyScheduleWithCaptureTransaction");
        try {
            service.dummyMethodWithNoTracing();
        } catch (InterruptedException e) {
            LOGGER.error("Problem with scheduler not waiting", e);
        }
    }

    @Scheduled(fixedDelay = 60000)
    @CaptureTransaction(type = "scheduled")
    public void dummyScheduleWithImpliedTracing() {
        LOGGER.info("Running dummyScheduleWithImpliedTracing");
        try {
            service.dummyMethodWithTracing();
        } catch (InterruptedException e) {
            LOGGER.error("Problem with scheduler not waiting", e);
        }
    }




}
