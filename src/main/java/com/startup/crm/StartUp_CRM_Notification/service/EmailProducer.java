package com.startup.crm.StartUp_CRM_Notification.service;

import com.startup.crm.StartUp_CRM_Notification.entity.EmailEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailProducer {

    private final KafkaTemplate<String, EmailEvent> kafkaTemplate;

    public void sendEmailEvent(EmailEvent event) {
        kafkaTemplate.send("email-events", event);
    }
}
