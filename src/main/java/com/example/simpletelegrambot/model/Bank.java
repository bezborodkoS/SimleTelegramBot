package com.example.simpletelegrambot.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Bank {


    private String nameBank;

    private List<CreditSetting> creditSettings;
    private List<Double> additionalExpenses;

    public List<Double> getAdditionalExpenses() {
        return additionalExpenses;
    }

    public void setAdditionalExpenses(List<Double> additionalExpenses) {
        this.additionalExpenses = additionalExpenses;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public List<CreditSetting> getCreditSettings() {
        return creditSettings;
    }

    public void setCreditSettings(List<CreditSetting> creditSettings) {
        this.creditSettings = creditSettings;
    }

}
