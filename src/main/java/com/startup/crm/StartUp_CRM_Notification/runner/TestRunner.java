package com.startup.crm.StartUp_CRM_Notification.runner;


import com.startup.crm.StartUp_CRM_Notification.entity.EmailEvent;
import com.startup.crm.StartUp_CRM_Notification.service.EmailProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

    private final EmailProducer producer;

    public TestRunner(EmailProducer producer) {
        this.producer = producer;
    }

    @Override
    public void run(String... args) throws Exception {
        EmailEvent event = new EmailEvent();
        event.setTo("dnt@gmail.com.com");
        event.setSubject("Test");
        event.setBody("Hello from Kafka");
        event.setType("msg");

        producer.sendEmailEvent(event);
    }
}
