package com.example.simpletelegrambot.services;

public class MessageService {

    public String getResponseMessage(String warningText, String text) {
        String responseMessage = "";
        if (warningText.isEmpty()) {
            String[] inputDataMass = text.split("\n");
            int totalCost = Integer.parseInt(inputDataMass[0]);
            int initialPay = Integer.parseInt(inputDataMass[1]);
            int monthlyPay = Integer.parseInt(inputDataMass[2]);
            responseMessage = getCreditData(totalCost, initialPay, monthlyPay);
        }
        return responseMessage;
    }

    public String getCreditData(int totalCost, int initialPay, int monthlyPay) {
     // Mazda
        //Toyota
        //  Reno


        CarCredit carCredit = new CarCredit();
       // carCredit.tableOut();
        return carCredit.carPay(totalCost, initialPay, monthlyPay); // output monthly cost for current initial pay, and highlights the closest monthly pay to provided
    }
}
