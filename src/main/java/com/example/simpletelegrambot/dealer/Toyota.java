package com.example.simpletelegrambot.dealer;

import com.example.simpletelegrambot.model.Bank;
import com.example.simpletelegrambot.model.CreditSetting;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Toyota extends AutoDealer {
    public Toyota() {
        this.nameAutoDealer = "Toyota";
        this.bankList = banksToyota();
    }

    private List<Bank> banksToyota(){

        List<CreditSetting> creditSettingsPrivat = new ArrayList<>();
        List<Double> additionalExpenses = new ArrayList<>();
        additionalExpenses.add(2.99);
        additionalExpenses.add(1.99);

        creditSettingsPrivat.add(new CreditSetting(12,30,3.49));
        creditSettingsPrivat.add(new CreditSetting(24,30,6.99));
        creditSettingsPrivat.add(new CreditSetting(36,30,8.99));
        creditSettingsPrivat.add(new CreditSetting(48,30,11.99));
        creditSettingsPrivat.add(new CreditSetting(60,30,11.99));
//        40
        creditSettingsPrivat.add(new CreditSetting(12,40,2.49));
        creditSettingsPrivat.add(new CreditSetting(24,40,5.99));
        creditSettingsPrivat.add(new CreditSetting(36,40,8.49));
        creditSettingsPrivat.add(new CreditSetting(48,40,11.99));
        creditSettingsPrivat.add(new CreditSetting(60,40,11.99));
//        50
        creditSettingsPrivat.add(new CreditSetting(12,50,1.49));
        creditSettingsPrivat.add(new CreditSetting(24,50,4.99));
        creditSettingsPrivat.add(new CreditSetting(36,50,7.49));
        creditSettingsPrivat.add(new CreditSetting(48,50,9.99));
        creditSettingsPrivat.add(new CreditSetting(60,50,9.99));
//        60
        creditSettingsPrivat.add(new CreditSetting(12,60,0.01));
        creditSettingsPrivat.add(new CreditSetting(24,60,3.99));
        creditSettingsPrivat.add(new CreditSetting(36,60,5.49));
        creditSettingsPrivat.add(new CreditSetting(48,60,9.99));
        creditSettingsPrivat.add(new CreditSetting(60,60,9.99));
//        70
        creditSettingsPrivat.add(new CreditSetting(12,70,0.01));
        creditSettingsPrivat.add(new CreditSetting(24,70,3.99));
        creditSettingsPrivat.add(new CreditSetting(36,70,5.49));
        creditSettingsPrivat.add(new CreditSetting(48,70,9.99));
        creditSettingsPrivat.add(new CreditSetting(60,70,9.99));


        Bank privatBank = new Bank();
        privatBank.setNameBank("PrivatBank");
        privatBank.setCreditSettings(creditSettingsPrivat);
        privatBank.setAdditionalExpenses(additionalExpenses);
        List<Bank> toyotaBanks = new ArrayList<>();
        toyotaBanks.add(privatBank);
        return toyotaBanks;
    }
}
