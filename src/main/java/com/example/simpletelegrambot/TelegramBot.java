package com.example.simpletelegrambot;

import com.example.simpletelegrambot.dto.LaunchPoolDTO;
import com.example.simpletelegrambot.service.ServerRequestsService;
import com.example.simpletelegrambot.service.UpdateCashFile;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class TelegramBot extends TelegramLongPollingBot {
    public static final long CHAT_ID_CHANAL = -1002459768052L;
    private UpdateCashFile updateCashFile = new UpdateCashFile();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
    private List<LaunchPoolDTO> launchPoolDTOListShow;


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String answer = update.getMessage().getText();
            System.out.println(answer + " answer");
            long chat_id = update.getMessage().getChatId();
            switch (answer.toLowerCase()) {
                case "/send":
                    showLaunchPool();
                    break;
                default:
                    sendMessage(chat_id, answer);
            }
        }
    }


    private void showLaunchPool() {
        scheduler.scheduleAtFixedRate(this::showStartSoonLaunchPools, 0, 3, TimeUnit.HOURS);
        scheduler.scheduleAtFixedRate(this::showActiveLaunchPools, 0, 7,TimeUnit.DAYS);
    }

    private void showStartSoonLaunchPools() {
        launchPoolDTOListShow = updateCashFile.showLaunchPoolListStartSoon();
        if (launchPoolDTOListShow.size()!=0&& updateCashFile.checkTime()) {
            for (LaunchPoolDTO launch : launchPoolDTOListShow) {
                sendMessage(CHAT_ID_CHANAL, launch.poolsShow(launch));
            }
        }
    }



    private void showActiveLaunchPools() {
        if (updateCashFile.showActiveLaunchPools().size()!=0) {
            sendMessage(CHAT_ID_CHANAL, "Active launch pools");
            for (LaunchPoolDTO launch : updateCashFile.showActiveLaunchPools()) {
                sendMessage(CHAT_ID_CHANAL, launch.poolsShow(launch));
            }
        }
    }



    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
//        message.setText(text);
        message.setText(text);
        try {
            execute(message);
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
        return "6923161415:AAHD3O9d1yZyzkpAavY9fu9JSgNQ4jNMvJs";

    }


}
