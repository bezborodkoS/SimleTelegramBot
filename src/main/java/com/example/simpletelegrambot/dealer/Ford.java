package com.example.simpletelegrambot.dealer;

import com.example.simpletelegrambot.model.Bank;
import com.example.simpletelegrambot.model.CreditSetting;

import java.util.ArrayList;
import java.util.List;

public class Ford extends AutoDealer{
    public Ford() {
        this.nameAutoDealer = "Ford";
        this.bankList = bankFord();
    }

    private List<Bank> bankFord(){

        List<CreditSetting> creditSettingsUkrGasBank = new ArrayList<>();
        List<Double> additionalExpenses = new ArrayList<>();
        additionalExpenses.add(2.99);
        additionalExpenses.add(1.99);

        creditSettingsUkrGasBank.add(new CreditSetting(12,30,6.99));
        creditSettingsUkrGasBank.add(new CreditSetting(24,30,9.59));
        creditSettingsUkrGasBank.add(new CreditSetting(36,30,11.59));
        creditSettingsUkrGasBank.add(new CreditSetting(48,30,12.19));
        creditSettingsUkrGasBank.add(new CreditSetting(60,30,12.69));
        creditSettingsUkrGasBank.add(new CreditSetting(72,30,13.09));
        creditSettingsUkrGasBank.add(new CreditSetting(83,30,13.39));

        creditSettingsUkrGasBank.add(new CreditSetting(12,40,5.75));
        creditSettingsUkrGasBank.add(new CreditSetting(24,40,8.49));
        creditSettingsUkrGasBank.add(new CreditSetting(36,40,10.59));
        creditSettingsUkrGasBank.add(new CreditSetting(48,40,11.29));
        creditSettingsUkrGasBank.add(new CreditSetting(60,40,11.79));
        creditSettingsUkrGasBank.add(new CreditSetting(72,40,12.19));
        creditSettingsUkrGasBank.add(new CreditSetting(83,40,12.59));
//        40
        creditSettingsUkrGasBank.add(new CreditSetting(12,50,4.19));
        creditSettingsUkrGasBank.add(new CreditSetting(24,50,6.99));
        creditSettingsUkrGasBank.add(new CreditSetting(36,50,9.19));
        creditSettingsUkrGasBank.add(new CreditSetting(48,50,9.89));
        creditSettingsUkrGasBank.add(new CreditSetting(60,50,10.49));
        creditSettingsUkrGasBank.add(new CreditSetting(72,50,11.09));
        creditSettingsUkrGasBank.add(new CreditSetting(83,50,11.49));
//        60
        creditSettingsUkrGasBank.add(new CreditSetting(12,60,1.69));
        creditSettingsUkrGasBank.add(new CreditSetting(24,60,4.69));
        creditSettingsUkrGasBank.add(new CreditSetting(36,60,6.99));
        creditSettingsUkrGasBank.add(new CreditSetting(48,60,7.89));
        creditSettingsUkrGasBank.add(new CreditSetting(60,60,8.59));
        creditSettingsUkrGasBank.add(new CreditSetting(72,60,8.29));
        creditSettingsUkrGasBank.add(new CreditSetting(83,60,8.89));
//        70
        creditSettingsUkrGasBank.add(new CreditSetting(12,70,0.01));
        creditSettingsUkrGasBank.add(new CreditSetting(24,70,0.89));
        creditSettingsUkrGasBank.add(new CreditSetting(36,70,3.39));
        creditSettingsUkrGasBank.add(new CreditSetting(48,70,4.49));
        creditSettingsUkrGasBank.add(new CreditSetting(60,70,5.49));
        creditSettingsUkrGasBank.add(new CreditSetting(72,60,6.19));
        creditSettingsUkrGasBank.add(new CreditSetting(83,60,6.89));


        Bank ukrGasBank = new Bank();
        ukrGasBank.setNameBank("UkrGasBank");
        ukrGasBank.setCreditSettings(creditSettingsUkrGasBank);
        ukrGasBank.setAdditionalExpenses(additionalExpenses);
        List<Bank> citroenBank = new ArrayList<>();
        citroenBank.add(ukrGasBank);
        return citroenBank;
    }
}
