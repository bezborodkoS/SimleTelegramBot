package com.example.simpletelegrambot.model;


import java.util.List;

public class Bank {

    private String nameBank;

    private List<CreditSetting> creditSettings;

    public Bank(String nameBank, List<CreditSetting> creditSettings) {
        this.nameBank = nameBank;
        this.creditSettings = creditSettings;
    }

    public String getNameBank() {
        return nameBank;
    }

    public List<CreditSetting> getCreditSettings() {
        return creditSettings;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public void setCreditSettings(List<CreditSetting> creditSettings) {
        this.creditSettings = creditSettings;
    }
}
