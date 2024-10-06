package com.example.simpletelegrambot.dto;


import com.example.simpletelegrambot.model.CreditSetting;

import java.text.DecimalFormat;

public class CreditSettingDTO {


    private int countMonthInYear;
    private int percentDeposit;
    private double percent;
    private double monthlyPayment;
    private String nameBank;

    public CreditSettingDTO() {
    }

    public CreditSettingDTO convertCreditSettingToDTO(CreditSetting creditSetting, String nameBank) {
        CreditSettingDTO creditSettingDTO = new CreditSettingDTO();
        creditSettingDTO.setCountMonthInYear(creditSetting.getMonth());
        creditSettingDTO.setPercentDeposit(creditSetting.getPercentDeposit());
        creditSettingDTO.setPercent(creditSetting.getPercent());
        creditSettingDTO.setNameBank(nameBank);

        return creditSettingDTO;
    }

    public CreditSetting convertDTOToCreditSetting(CreditSettingDTO creditSettingDTO) {
        CreditSetting creditSetting = new CreditSetting();
        creditSetting.setMonth(creditSettingDTO.getCountMonthInYear());
        creditSetting.setPercentDeposit(creditSettingDTO.getPercentDeposit());
        creditSetting.setPercent(creditSettingDTO.getPercent());
        return creditSetting;
    }


    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public int getCountMonthInYear() {
        return countMonthInYear;
    }

    public int getPercentDeposit() {
        return percentDeposit;
    }

    public double getPercent() {
        return percent;
    }

    public void setCountMonthInYear(int countMonthInYear) {
        this.countMonthInYear = countMonthInYear;
    }

    public void setPercentDeposit(int percentDeposit) {
        this.percentDeposit = percentDeposit;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return "Банк:" + nameBank +
                "\nКоличество месяцев=" + countMonthInYear +
                "\nРазовая оплата от общей стоимости автомобиля=" + percentDeposit +
                "\nПроцентная ставка в месяц=" + percent +"%"+
                "\nЕжемесячный платеж=" + decimalFormat.format(monthlyPayment);
    }
}
