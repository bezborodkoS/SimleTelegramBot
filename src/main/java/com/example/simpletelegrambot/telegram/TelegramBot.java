package com.example.simpletelegrambot.telegram;

import com.example.simpletelegrambot.services.MessageService;
import com.example.simpletelegrambot.validation.ValidationProcessor;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class TelegramBot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String answer = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
//            if (answer.equals("/start")) {
//                sendNavigationButtons(chatId);
//            }
            sendMessage(answer, chatId);
       }
//        else if (update.hasCallbackQuery()) {
//            String callbackData = update.getCallbackQuery().getData();
//            long chatId = update.getCallbackQuery().getMessage().getChatId();
//
//            switch (callbackData) {
//                case "button_1":
//                    sendMessage("Ви натиснули на кнопку 1", chatId);
//                    break;
//                case "button_2":
//                    sendMessage("Ви натиснули на кнопку 2", chatId);
//                    break;
//                default:
//                    sendMessage("Невідома команда", chatId);
//            }
//        }
    }

    private void sendMessage(String text, long chat_id) {
        ValidationProcessor validationProcessor = new ValidationProcessor();
        String warningText = validationProcessor.validate(text);
        MessageService messageService = new MessageService();
        String responseMessage = messageService.getResponseMessage(warningText, text);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat_id);
        if (!warningText.isEmpty()) {
            sendMessage.setText(warningText);
        }else {
            sendMessage.setText(responseMessage);
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendNavigationButtons(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Оберіть опцію:");

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        // Кнопка 1
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        InlineKeyboardButton btn1 = new InlineKeyboardButton();
        btn1.setText("Порахувати дохідність");
        btn1.setCallbackData("button_1");
        rowInline1.add(btn1);

        // Кнопка 2
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        InlineKeyboardButton btn2 = new InlineKeyboardButton();
        btn2.setText("Розрахувати % купівлі авто");
        btn2.setCallbackData("button_2");
        rowInline2.add(btn2);

        // Додати кнопки до рядків
        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);

        // Встановити кнопки у повідомлення
        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return "Art_car_calculator_bot";
    }

    @Override
    public String getBotToken() {
        return "7524858228:AAHOOHHDHn_DJECA_jvEahBWS1VoCI70Yro";
    }
}
