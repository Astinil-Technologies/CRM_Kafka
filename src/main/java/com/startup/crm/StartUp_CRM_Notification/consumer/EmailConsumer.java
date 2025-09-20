package com.startup.crm.StartUp_CRM_Notification.consumer;

import com.startup.crm.StartUp_CRM_Notification.entity.EmailEvent;
import com.startup.crm.StartUp_CRM_Notification.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailConsumer {

    private final EmailService emailService;

    @KafkaListener(topics = "email-notifications", groupId = "notification-service")
    public void onMessage(EmailEvent event) {
        if (event == null) {
            log.warn("Received empty or invalid message, skipping...");
            return;
        }

        try {
            emailService.sendEmail(event);
        } catch (Exception e) {
            log.error("Failed to send email for message {}", event, e);
        }
    }
}