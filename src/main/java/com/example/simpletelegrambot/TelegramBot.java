package com.example.simpletelegrambot;

import ch.qos.logback.core.util.TimeUtil;
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

    private  GetMethod getMethod = new GetMethod();
    //    private int numb1 = 0;
//    private int numb2 = 0;
//    private boolean gameRunning = false;
    private long gameChatId;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private List<LaunchPoolDTO> launchPoolDTOListShow;


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String answer = update.getMessage().getText();
            System.out.println(answer + " answer");
            long chat_id = update.getMessage().getChatId();
            switch (answer.toLowerCase()) {
//                case "/игра":
//                    startGame(chat_id);
//                    break;
//                case "/стоп":
//                    stopGame(chat_id);
//                    break;
                case "/send":
                    showLaunchPool();
//                    sendMessage(CHAT_ID_CHANAL, showLaunchPool());
                    break;
                default:
                    sendMessage(chat_id, answer);
            }
        }
    }

//    private void getLaunchPools(){
//
//
//    }

    private void showLaunchPool(){
        List<LaunchPoolDTO> launchPoolDTOList = getMethod.returnBody();
//        scheduler.scheduleAtFixedRate(this:getLaunchPools(chat_id,launchPoolDTOList), 0,5,TimeUtil.)
        scheduler.scheduleAtFixedRate(this::getLaunchPools, 0, 10, TimeUnit.MINUTES);
//        for (LaunchPoolDTO launch : launchPoolDTOList) {
//            sendMessage(CHAT_ID_CHANAL,launch.poolsShow(launch));
//        }

    }

    private void getLaunchPools() {
        launchPoolDTOListShow=getMethod.returnBody();
        System.out.println("size"+ launchPoolDTOListShow.size());
        for (LaunchPoolDTO launch : launchPoolDTOListShow) {
            sendMessage(CHAT_ID_CHANAL,launch.poolsShow(launch));
        }
    }


//    private void startGame(long chatId) {
//        if (!gameRunning) {
//            gameRunning = true;
//            gameChatId = chatId;
//            sendMessage(chatId, "Игра началась! Генерация чисел...");
//            scheduler.scheduleAtFixedRate(this::sendRandomNumbers, 0, 5, TimeUnit.SECONDS);
//        } else {
//            sendMessage(chatId, "Игра уже идет!");
//        }
//    }
//
//    private void stopGame(long chatId) {
//        if (gameRunning) {
//            gameRunning = false;
//            scheduler.shutdownNow();
//            String result = (numb1 == numb2) ? "Поздравляю! Числа совпали." : "Поражение. Числа не совпали.";
//            sendMessage(chatId, result + " Выход на главную.");
//            scheduler = Executors.newScheduledThreadPool(1);
//        } else {
//            sendMessage(chatId, "Игра не идет.");
//        }
//    }
//
//    private void sendRandomNumbers() {
//        if (gameRunning) {
//            numb1 = new SpecialMethods().returnRandomNumb();
//            numb2 = new SpecialMethods().returnRandomNumb();
//            String text = numb1 + "               " + numb2;
//            sendMessage(gameChatId, text);
//        }
//    }

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
