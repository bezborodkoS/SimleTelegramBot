package com.example.simpletelegrambot.dealer;

import com.example.simpletelegrambot.model.Bank;
import com.example.simpletelegrambot.model.CreditSetting;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mazda extends AutoDealer {
    public Mazda() {
        this.nameAutoDealer = "Mazda";
        this.bankList = banksMazda();
    }

    private List<Bank> banksMazda(){
        List<CreditSetting> creditSettingsPrivat = new ArrayList<>();
        List<Double> additionalExpensesPrivat = new ArrayList<>();
        additionalExpensesPrivat.add(2.99);
        additionalExpensesPrivat.add(1.99);

        creditSettingsPrivat.add(new CreditSetting(24,20,6.5));
        creditSettingsPrivat.add(new CreditSetting(36,20,21.9));
        creditSettingsPrivat.add(new CreditSetting(48,20,21.9));
        creditSettingsPrivat.add(new CreditSetting(60,20,21.9));
        //        30
        creditSettingsPrivat.add(new CreditSetting(24,30,4.9));
        creditSettingsPrivat.add(new CreditSetting(36,30,21.9));
        creditSettingsPrivat.add(new CreditSetting(48,30,21.9));
        creditSettingsPrivat.add(new CreditSetting(60,30,21.9));
//        40
        creditSettingsPrivat.add(new CreditSetting(24,40,2.9));
        creditSettingsPrivat.add(new CreditSetting(36,40,21.9));
        creditSettingsPrivat.add(new CreditSetting(48,40,21.9));
        creditSettingsPrivat.add(new CreditSetting(60,40,21.9));
//        50

        creditSettingsPrivat.add(new CreditSetting(24,50,0.01));
        creditSettingsPrivat.add(new CreditSetting(36,50,21.9));
        creditSettingsPrivat.add(new CreditSetting(48,50,21.9));
        creditSettingsPrivat.add(new CreditSetting(60,50,21.9));
//        60
        creditSettingsPrivat.add(new CreditSetting(24,60,3.99));
        creditSettingsPrivat.add(new CreditSetting(36,60,14.9));
        creditSettingsPrivat.add(new CreditSetting(48,60,14.9));
        creditSettingsPrivat.add(new CreditSetting(60,60,14.9));

        List<CreditSetting> creditSettingsOshad = new ArrayList<>();
//      20
        creditSettingsOshad.add(new CreditSetting(12,20,6.99));
        creditSettingsOshad.add(new CreditSetting(24,20,10.99));
        creditSettingsOshad.add(new CreditSetting(36,20,11.99));
        creditSettingsOshad.add(new CreditSetting(60,20,14.99));
        creditSettingsOshad.add(new CreditSetting(84,20,15.99));

//        30
        creditSettingsOshad.add(new CreditSetting(12,30,4.99));
        creditSettingsOshad.add(new CreditSetting(24,30,8.99));
        creditSettingsOshad.add(new CreditSetting(36,30,9.99));
        creditSettingsOshad.add(new CreditSetting(60,30,12.99));
        creditSettingsOshad.add(new CreditSetting(84,30,14.99));
//        40
        creditSettingsOshad.add(new CreditSetting(12,40,2.99));
        creditSettingsOshad.add(new CreditSetting(24,40,7.99));
        creditSettingsOshad.add(new CreditSetting(36,40,8.99));
        creditSettingsOshad.add(new CreditSetting(60,40,12.99));
        creditSettingsOshad.add(new CreditSetting(84,40,12.99));
//        50

        creditSettingsOshad.add(new CreditSetting(12,50,0.01));
        creditSettingsOshad.add(new CreditSetting(24,50,3.99));
        creditSettingsOshad.add(new CreditSetting(36,50,7.99));
        creditSettingsOshad.add(new CreditSetting(60,50,11.99));
        creditSettingsOshad.add(new CreditSetting(84,50,12.99));
//        60
        creditSettingsOshad.add(new CreditSetting(12,60,0.01));
        creditSettingsOshad.add(new CreditSetting(24,60,0.01));
        creditSettingsOshad.add(new CreditSetting(36,60,4.99));
        creditSettingsOshad.add(new CreditSetting(60,60,9.99));
        creditSettingsOshad.add(new CreditSetting(84,60,10.99));
//        70
        creditSettingsOshad.add(new CreditSetting(12,70,0.01));
        creditSettingsOshad.add(new CreditSetting(24,70,0.01));
        creditSettingsOshad.add(new CreditSetting(36,70,0.01));
        creditSettingsOshad.add(new CreditSetting(60,70,6.99));
        creditSettingsOshad.add(new CreditSetting(84,70,7.99));

        List<Double> additionalExpensesOshad = new ArrayList<>();
        additionalExpensesOshad.add(3.5);

        Bank oshadBank = new Bank();
        oshadBank.setNameBank("OshadBank");
        oshadBank.setCreditSettings(creditSettingsOshad);
        oshadBank.setAdditionalExpenses(additionalExpensesOshad);
        Bank privatBank = new Bank();
        privatBank.setNameBank("PrivatBank");
        privatBank.setCreditSettings(creditSettingsPrivat);
        privatBank.setAdditionalExpenses(additionalExpensesPrivat);
        List<Bank> mazdaBanks = new ArrayList<>();
        mazdaBanks.add(privatBank);
        mazdaBanks.add(oshadBank);
        return  mazdaBanks;

    }


}
