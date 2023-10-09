package com.socialshop.backend.emailservice.services.impls;

import com.socialshop.backend.emailservice.constant.KafkaTopicConstant;
import com.socialshop.backend.emailservice.services.EmailService;
import com.socialshop.backend.emailservice.services.event.EmailSendEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public void requestSendEmail(EmailSendEvent event) {
        // Try block to check for exceptions
        try {
            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(event.getEmail());
            mailMessage.setText(event.getContent());
            mailMessage.setSubject("Verification Email Code");
            // Sending the mail
            javaMailSender.send(mailMessage);
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
