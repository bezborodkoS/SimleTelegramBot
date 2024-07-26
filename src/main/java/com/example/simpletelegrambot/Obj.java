package com.example.simpletelegrambot;

public class Obj {
    private long chatId;
    private String text;

    public long getChatId() {
        return chatId;
    }

    public String getText() {
        return text;
    }

    public Obj(long chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }
}
