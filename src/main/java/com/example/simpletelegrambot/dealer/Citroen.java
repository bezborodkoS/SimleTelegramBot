package com.example.simpletelegrambot.dealer;

import com.example.simpletelegrambot.model.Bank;
import com.example.simpletelegrambot.model.CreditSetting;

import java.util.ArrayList;
import java.util.List;

public class Citroen extends AutoDealer{
    public Citroen() {
        this.nameAutoDealer = "Citroen";
        this.bankList = bankCitroen();
    }

    private List<Bank> bankCitroen(){

        List<CreditSetting> creditSettingsOshad = new ArrayList<>();
        List<Double> additionalExpenses = new ArrayList<>();
        additionalExpenses.add(2.99);
        additionalExpenses.add(1.99);

        creditSettingsOshad.add(new CreditSetting(12,20,6.99));
        creditSettingsOshad.add(new CreditSetting(24,20,9.49));
        creditSettingsOshad.add(new CreditSetting(36,20,11.99));
        creditSettingsOshad.add(new CreditSetting(48,20,12.99));
        creditSettingsOshad.add(new CreditSetting(60,20,12.99));
        creditSettingsOshad.add(new CreditSetting(72,20,13.49));
        creditSettingsOshad.add(new CreditSetting(83,20,13.49));

        creditSettingsOshad.add(new CreditSetting(12,30,5.99));
        creditSettingsOshad.add(new CreditSetting(24,30,8.49));
        creditSettingsOshad.add(new CreditSetting(36,30,10.49));
        creditSettingsOshad.add(new CreditSetting(48,30,11.99));
        creditSettingsOshad.add(new CreditSetting(60,30,11.99));
        creditSettingsOshad.add(new CreditSetting(72,30,12.99));
        creditSettingsOshad.add(new CreditSetting(83,30,12.99));
//        40
        creditSettingsOshad.add(new CreditSetting(12,40,4.49));
        creditSettingsOshad.add(new CreditSetting(24,40,7.49));
        creditSettingsOshad.add(new CreditSetting(36,40,9.49));
        creditSettingsOshad.add(new CreditSetting(48,40,10.99));
        creditSettingsOshad.add(new CreditSetting(60,40,10.99));
        creditSettingsOshad.add(new CreditSetting(72,40,11.99));
        creditSettingsOshad.add(new CreditSetting(83,40,11.99));
//        50
        creditSettingsOshad.add(new CreditSetting(12,50,2.99));
        creditSettingsOshad.add(new CreditSetting(24,50,5.49));
        creditSettingsOshad.add(new CreditSetting(36,50,7.99));
        creditSettingsOshad.add(new CreditSetting(48,50,9.99));
        creditSettingsOshad.add(new CreditSetting(60,50,9.99));
        creditSettingsOshad.add(new CreditSetting(72,50,10.99));
        creditSettingsOshad.add(new CreditSetting(83,50,10.99));
//        60
        creditSettingsOshad.add(new CreditSetting(12,60,0.01));
        creditSettingsOshad.add(new CreditSetting(24,60,2.99));
        creditSettingsOshad.add(new CreditSetting(36,60,5.49));
        creditSettingsOshad.add(new CreditSetting(48,60,7.49));
        creditSettingsOshad.add(new CreditSetting(60,60,7.49));
        creditSettingsOshad.add(new CreditSetting(72,60,8.49));
        creditSettingsOshad.add(new CreditSetting(83,60,8.49));
//        70
        creditSettingsOshad.add(new CreditSetting(12,70,0.01));
        creditSettingsOshad.add(new CreditSetting(24,70,0.01));
        creditSettingsOshad.add(new CreditSetting(36,70,0.99));
        creditSettingsOshad.add(new CreditSetting(48,70,3.49));
        creditSettingsOshad.add(new CreditSetting(60,70,3.49));
        creditSettingsOshad.add(new CreditSetting(72,60,3.99));
        creditSettingsOshad.add(new CreditSetting(83,60,3.99));


        Bank oshadBank = new Bank();
        oshadBank.setNameBank("OshadBank");
        oshadBank.setCreditSettings(creditSettingsOshad);
        oshadBank.setAdditionalExpenses(additionalExpenses);
        List<Bank> citroenBank = new ArrayList<>();
        citroenBank.add(oshadBank);
        return citroenBank;
    }
}
