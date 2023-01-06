package com.socket.example.websockets;

public class NotificationMessage {

    private String from;
    private String text;
    private String to;

    public String getText() {
        return text;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
