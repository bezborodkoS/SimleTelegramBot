package com.example.simpletelegrambot;


//import com.example.simpletelegrambot.service.CalculatorService;

import com.example.simpletelegrambot.dto.CreditSettingDTO;
import com.example.simpletelegrambot.service.CalculatorService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class TelegramBot extends TelegramLongPollingBot {

    private CalculatorService calculatorService;
    private boolean expectingUserData = false;
    private int numb1 = 0;
    private int numb2 = 0;
    private boolean gameRunning = false;
    private long gameChatId;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String answer = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            sendMessage(chat_id,"/game -> запустить игру с числами\n /stop -> остановить игру\n/form -> отправить запрос на калькулятор кредита автомобиля");
            if (answer.toLowerCase().equals("/game")) {
                startGame(chat_id);
            } else if (answer.toLowerCase().equals("/stop")) {
                stopGame(chat_id);
            } else if (answer.toLowerCase().equals("/form")) {
                expectingUserData = true;
                sendMessage(chat_id, "Пожалуйста, введите ваши данные в формате:\nСалон, Стоимость машины, Депозит, Сколько вы хотите платить");
            } else if (expectingUserData) {
                processUserData(answer, chat_id);
                expectingUserData = false;          // Сброс ожидания после получения данных
            } else {
                sendMessage(chat_id, "Неверная команда. Введите /form, /игра, /стоп для начала.");
            }
        }
    }


    private void startGame(long chatId) {
        if (!gameRunning) {
            gameRunning = true;
            gameChatId = chatId;
            sendMessage(chatId, "Игра началась! Генерация чисел...");
            scheduler.scheduleAtFixedRate(this::sendRandomNumbers, 0, 5, TimeUnit.SECONDS);
        } else {
            sendMessage(chatId, "Игра уже идет!");
        }
    }

    private void stopGame(long chatId) {
        if (gameRunning) {
            gameRunning = false;
            scheduler.shutdownNow();
            String result = (numb1 == numb2) ? "Поздравляю! Числа совпали." : "Поражение. Числа не совпали.";
            sendMessage(chatId, result + " Выход на главную.");
            scheduler = Executors.newScheduledThreadPool(1);
        } else {
            sendMessage(chatId, "Игра не идет.");
        }
    }

    private void sendRandomNumbers() {
        if (gameRunning) {
            numb1 = new SpecialMethods().returnRandomNumb();
            numb2 = new SpecialMethods().returnRandomNumb();
            String text = numb1 + "               " + numb2;
            sendMessage(gameChatId, text);
        }
    }


    private void processUserData(String userData, long chat_id) {
        String[] data = userData.split(",");
        if (data.length == 4) {
            String autoDealer = data[0].trim();
            double costCar = Double.parseDouble(data[1].trim());
            double deposit = Double.parseDouble(data[2].trim());
            double wantPayInMonth = Double.parseDouble(data[3].trim());

            ArrayList<CreditSettingDTO> creditSettingDTOArrayList = new CalculatorService().canBuyCar(costCar, deposit, wantPayInMonth, autoDealer);
            double wantPayInMonthUsing= wantPayInMonth;
            if (creditSettingDTOArrayList.size()==0){
                do {
                    wantPayInMonthUsing+=1000;
                    creditSettingDTOArrayList = new CalculatorService().canBuyCar(costCar, deposit, wantPayInMonthUsing, autoDealer);
                }while (creditSettingDTOArrayList.size()==0);
                sendMessage(chat_id, "Никаких вариантов не найденою минимальный месячный платеж: "+wantPayInMonthUsing);
            }
            for (CreditSettingDTO credit : creditSettingDTOArrayList) {
                sendMessage(chat_id, credit.toString());
            }
            // Обработка и сохранение данных
            sendMessage(chat_id, "Данные получены:\nСалон: " + autoDealer + "\nСтоимость машины: " + costCar + "\nДепозит: " + deposit + "\nСколько вы хотите платить " + wantPayInMonth);
        } else {
            sendMessage(chat_id, "Пожалуйста, введите данные в правильном формате.");
        }
//        expectingUserData=false;
    }


    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
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
