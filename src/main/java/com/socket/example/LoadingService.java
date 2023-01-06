// © 2022 Rakuten Symphony. All rights reserved.
package com.socket.example;

import com.socket.example.websockets.Message;
import com.socket.example.websockets.NotificationMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class LoadingService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public LoadingService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }


    @Async("processExecutor")
    public CompletableFuture<String> compareById(String user) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //
        }

        simpMessagingTemplate.convertAndSendToUser(user, "/specific", new Message("Operation is finished, " + user));

        return CompletableFuture.completedFuture("Done");
    }

}
