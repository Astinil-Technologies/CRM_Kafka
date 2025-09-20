package com.startup.crm.StartUp_CRM_Notification.service;

import com.startup.crm.StartUp_CRM_Notification.entity.EmailEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendEmail(EmailEvent e) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(e.getTo());
            msg.setSubject(e.getSubject());
            msg.setText(e.getBody());
            mailSender.send(msg);
            log.info("Email sent to {}", e.getTo());
        } catch (Exception ex) {
            log.error("Failed to send email for message {}", e, ex);
        }
    }
}
