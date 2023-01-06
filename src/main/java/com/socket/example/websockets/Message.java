package com.socket.example.websockets;

public class Message {

    private String from;
    private String text;

    public Message(String text) {
        this.text = text;
    }

    public Message() {
    }

    public String getText() {
        return text;
    }

    public String getFrom() {
        return from;
    }
}
