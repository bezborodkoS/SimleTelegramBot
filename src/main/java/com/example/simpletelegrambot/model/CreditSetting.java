package com.example.simpletelegrambot.model;

import org.springframework.stereotype.Component;

@Component
public class CreditSetting {

    private Integer month;

    private Integer percentDeposit;

    private Double percent;

    public CreditSetting() {
    }

    public CreditSetting(Integer month, Integer percentDeposit, Double percent) {
        this.month = month;
        this.percentDeposit = percentDeposit;
        this.percent = percent;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getPercentDeposit() {
        return percentDeposit;
    }

    public Double getPercent() {
        return percent;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public void setPercentDeposit(Integer percentDeposit) {
        this.percentDeposit = percentDeposit;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    //    public Bank getBank() {
//        return bank;
//    }
//
//    public void setBank(Bank bank) {
//        this.bank = bank;
//    }


    public String buttonSettings() {
        return month +" "+ percentDeposit +"% " + percent;
    }
}
