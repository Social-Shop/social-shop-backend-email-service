package com.socialshop.backend.emailservice.mq.consumer;

import com.socialshop.backend.emailservice.constant.KafkaTopicConstant;
import com.socialshop.backend.emailservice.services.EmailService;
import com.socialshop.backend.emailservice.services.event.EmailSendEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EmailConsumer {
    private final EmailService emailService;
    @KafkaListener(topics = {KafkaTopicConstant.emailOtpRegisterVerification}, groupId = "group1")
    public void requestSendEmail(EmailSendEvent event) {
        log.info("Email : {}", event.getContent());
        emailService.requestSendEmail(event);
    }
}
