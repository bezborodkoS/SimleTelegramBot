package com.example.simpletelegrambot.model;



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

    @Override
    public String toString() {
        return "CreditSetting{" +
                ", month=" + month +
                ", percentDeposit=" + percentDeposit +
                ", percent=" + percent +
                '}';
    }
}
