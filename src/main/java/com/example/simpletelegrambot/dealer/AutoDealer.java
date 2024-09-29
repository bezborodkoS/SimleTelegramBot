package com.example.simpletelegrambot.dealer;

import com.example.simpletelegrambot.model.Bank;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public abstract class AutoDealer {
    protected String nameAutoDealer;
    protected List<Bank> bankList;

    public String getNameAutoDealer() {
        return nameAutoDealer;
    }

    public void setNameAutoDealer(String nameAutoDealer) {
        this.nameAutoDealer = nameAutoDealer;
    }

    public List<Bank> getBankList() {
        return bankList;
    }

    public void setBankList(List<Bank> bankList) {
        this.bankList = bankList;
    }
}
