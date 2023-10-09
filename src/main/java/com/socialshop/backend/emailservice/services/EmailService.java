package com.socialshop.backend.emailservice.services;

import com.socialshop.backend.emailservice.services.event.EmailSendEvent;

public interface EmailService {
    void requestSendEmail(EmailSendEvent event);
}
