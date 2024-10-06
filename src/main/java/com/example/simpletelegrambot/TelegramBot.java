package com.example.simpletelegrambot;


import com.example.simpletelegrambot.dealer.AutoDealer;
import com.example.simpletelegrambot.dealer.Mazda;
import com.example.simpletelegrambot.dealer.Toyota;
import com.example.simpletelegrambot.dto.CreditSettingDTO;
import com.example.simpletelegrambot.service.CalculatorService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class TelegramBot extends TelegramLongPollingBot {


    private CalculatorService calculatorService;
//    ArrayList<String> autoDealerArrayList = new CalculatorService().allAutoDealer();
    private boolean expectingUserData = false;

    private boolean booleanButtons = false;
    private boolean expectingAllSettings = false;

    private boolean expectingAllBanks = false;
    private boolean expectingCostCar = false;

    private int numb1 = 0;
    private int numb2 = 0;
    private boolean gameRunning = false;
    private long gameChatId;
    private String nameAutoDealer;
    private String nameBank;
    private double costCar;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String answer = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            sendMessage(chat_id, "/game -> запустить игру с числами\n /stop -> остановить игру\n/form -> отправить запрос на калькулятор кредита автомобиля\n/allsettings -> allSettings");
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
            } else if (answer.toLowerCase().equals("/allsettings")) {
                expectingCostCar =true;
                sendMessage(chat_id, "Пожалуйста, cтоимость машины:");
            } else if (expectingCostCar) {
                costCar= Double.parseDouble(answer);
                System.out.println(costCar+" costCar");
            expectingAllSettings = true;
                sendMessage(chat_id, "Пожалуйста, введите ваши данные в формате:Салон");
                sendMessage(chat_id, "Салоны: "+ new CalculatorService().allAutoDealer().toString());
//                expectingAllSettings=false;
                expectingCostCar=false;
            }else if (expectingAllSettings&&new CalculatorService().allAutoDealer().contains(answer)) {
                expectingAllBanks = true;
                nameAutoDealer = answer;
                System.out.println(nameAutoDealer+" autodealer");
                sendMessage(chat_id, "Пожалуйста, введите ваши данные в формате:Банк");
                sendMessage(chat_id, "Банк: "+ new CalculatorService().allBanks(nameAutoDealer).toString());
            } else if (expectingAllBanks&&new CalculatorService().allBanks(nameAutoDealer).contains(answer)) {
                nameBank = answer;
//                if (new CalculatorService().allAutoDealer().contains(answer.toLowerCase())) {
                    System.out.println(nameBank + " bank");
                    booleanButtons = true;
                    sendButtonsWhithAllSettings(chat_id, answer, getKeyboardOptions(nameAutoDealer,nameBank));
                    expectingAllSettings = false;
//                }
        } else if (booleanButtons) {
                    processButtonClick(answer); // Обрабатываем нажатие
                    returnDtoByButton(nameAutoDealer,nameBank,costCar,answer,chat_id);
                    booleanButtons= false;
                    nameBank=null;
                    costCar = 0;
                    nameAutoDealer=null;
        } else {

                sendMessage(chat_id, "Неверная команда. Введите /form, /игра, /стоп для начала.");
            }
        }
    }

    private void returnDtoByButton(String nameAutoDealer,String nameBank,double costCar,String creditSetting,long chat_id){
        String[] data = creditSetting.replaceAll("%","").split(" ");
        if (data.length == 3) {

            int month = Integer.parseInt(data[0].trim());
            int percentDeposit = Integer.parseInt(data[1].trim());
            double percent = Double.parseDouble(data[2].trim());
            System.out.println(month);
            System.out.println(percentDeposit);
            System.out.println(percent);
            System.out.println("month "+month+" Deposit "+percentDeposit+" percent "+percent+" auto dealer "+nameAutoDealer+" bank "+nameBank+" cost "+costCar);
            CreditSettingDTO creditSettingDTO = new CalculatorService().returnConcreteSetting(month,percentDeposit,percent,nameBank,nameAutoDealer,costCar);
            sendMessage(chat_id,creditSettingDTO.toString());
        }
    }


    // Метод, возвращающий коллекцию кнопок
    private List<String> getKeyboardOptions(String nameAutoDealer,String nameBank) {
        for (String s :
                new CalculatorService().allSettings(nameAutoDealer,nameBank)) {
            System.out.println(s);
        }
        return new CalculatorService().allSettings(nameAutoDealer,nameBank);
    }

    //    Метод для обработки всех кнопок с всеми процентными ставками
    private void sendButtonsWhithAllSettings(long chatId, String text, List<String> options) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);


        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true); // Клавиатура будет подстраиваться под количество кнопок

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        for (String option : options) {
            KeyboardRow row = new KeyboardRow();
            row.add(new KeyboardButton(option));
            keyboardRows.add(row);
        }

        keyboardMarkup.setKeyboard(keyboardRows);
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message); // Отправляем сообщение с клавиатурой
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


//        // Создание сетки кнопок из коллекции
//        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
//        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
//        // Коллекция с кнопками
//        List<String> buttonLabels = new CalculatorService().allSettings(text);
//        System.out.println(buttonLabels.size() + " button");
//        // Генерация кнопок
//        for (String label : buttonLabels) {
//            List<InlineKeyboardButton> rowInline = new ArrayList<>();
//            InlineKeyboardButton button = new InlineKeyboardButton();
//            button.setText(label);
//            button.setCallbackData(label); // CallbackData для обработки нажатия кнопки
//            rowInline.add(button);
//            rowsInline.add(rowInline);
//        }
//        // Устанавливаем кнопки в сообщение
//        markupInline.setKeyboard(rowsInline);
//        message.setReplyMarkup(markupInline);
//
//        try {
//            execute(message);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
    }

    private void processButtonClick(String buttonText) {
        // Логика обработки нажатой кнопки
        System.out.println("Вы нажали на: " + buttonText);
    }

    //    Метод обработки /form и возврата результата
    private void processUserData(String userData, long chat_id) {
        String[] data = userData.split(",");
        if (data.length == 4) {
            String autoDealer = data[0].trim();
            double costCar = Double.parseDouble(data[1].trim());
            double deposit = Double.parseDouble(data[2].trim());
            double wantPayInMonth = Double.parseDouble(data[3].trim());

            ArrayList<CreditSettingDTO> creditSettingDTOArrayList = new CalculatorService().canBuyCar(costCar, deposit, wantPayInMonth, autoDealer);
            double wantPayInMonthUsing = wantPayInMonth;
            if (creditSettingDTOArrayList.size() == 0) {
                do {
                    wantPayInMonthUsing += 1000;
                    creditSettingDTOArrayList = new CalculatorService().canBuyCar(costCar, deposit, wantPayInMonthUsing, autoDealer);
                } while (creditSettingDTOArrayList.size() == 0);
                sendMessage(chat_id, "Никаких вариантов не найденою. Минимальный месячный платеж: " + wantPayInMonthUsing);
            }
            for (CreditSettingDTO credit : creditSettingDTOArrayList) {
                sendMessage(chat_id, credit.toString());
            }
            // Обработка и сохранение данных
            sendMessage(chat_id, "Данные получены:\nСалон: " + autoDealer + "\nСтоимость машины: " + costCar + "\nДепозит: " + deposit + "\nСколько вы хотите платить " + wantPayInMonth);
        } else {
            sendMessage(chat_id, "Пожалуйста, введите данные в правильном формате.");
        }
    }


    //    Игра
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
//    Конец игры

    //    Отправка сообщений
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
