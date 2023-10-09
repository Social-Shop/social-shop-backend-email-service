package com.socialshop.backend.emailservice.services.event;

import lombok.Data;

@Data
public class EmailSendEvent {
    private String email;
    private String content;
}
