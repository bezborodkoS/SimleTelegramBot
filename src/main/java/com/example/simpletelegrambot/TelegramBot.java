package com.example.simpletelegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String answer = update.getMessage().getText();
            System.out.println(answer);
            long chat_id = update.getMessage().getChatId();
            sendMessage(answer, chat_id);
        }
    }

    private void sendMessage(String text, long chat_id) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat_id);
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "Simple_qwerty_bot";
    }

    @Override
    public String getBotToken() {
        System.out.println("test");
        return "6923161415:AAHD3O9d1yZyzkpAavY9fu9JSgNQ4jNMvJs";

    }



}
