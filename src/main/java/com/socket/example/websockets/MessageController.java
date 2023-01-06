package com.socket.example.websockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public MessageController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/application")
    @SendTo("/all/messages")
    public NotificationMessage send(final NotificationMessage notificationMessage) throws Exception {
        return notificationMessage;
    }

    @MessageMapping("/private")
    public void sendToSpecificUser(@Payload NotificationMessage notificationMessage) {
        simpMessagingTemplate.convertAndSendToUser(notificationMessage.getTo(), "/specific", notificationMessage);
    }
}
