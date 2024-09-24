package com.example.simpletelegrambot.model;


import java.util.List;

public class Bank {

    private String nameBank;

    private List<CreditSetting> creditSettings;

    private List<Double> additionalExpenses;

    public Bank(String nameBank, List<CreditSetting> creditSettings,List<Double> additionalExpenses) {
        this.nameBank = nameBank;
        this.creditSettings = creditSettings;
        this.additionalExpenses = additionalExpenses;
    }

    public String getNameBank() {
        return nameBank;
    }

    public List<CreditSetting> getCreditSettings() {
        return creditSettings;
    }

    public List<Double> getAdditionalExpenses() {
        return additionalExpenses;
    }

    public void setAdditionalExpenses(List<Double> additionalExpenses) {
        this.additionalExpenses = additionalExpenses;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public void setCreditSettings(List<CreditSetting> creditSettings) {
        this.creditSettings = creditSettings;
    }
}
