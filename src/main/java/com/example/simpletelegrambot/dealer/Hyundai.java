package com.example.simpletelegrambot.dealer;

import com.example.simpletelegrambot.model.Bank;
import com.example.simpletelegrambot.model.CreditSetting;

import java.util.ArrayList;
import java.util.List;

public class Hyundai extends AutoDealer{
    public Hyundai() {
        this.nameAutoDealer = "Hyundai";
        this.bankList = bankHyundai();
    }

    private List<Bank> bankHyundai(){

        List<CreditSetting> creditSettingsPrivat = new ArrayList<>();
        List<Double> additionalExpenses = new ArrayList<>();
        additionalExpenses.add(2.5);
        additionalExpenses.add(1.99);

        creditSettingsPrivat.add(new CreditSetting(12,20,8.50));
        creditSettingsPrivat.add(new CreditSetting(24,20,11.00));
        creditSettingsPrivat.add(new CreditSetting(36,20,12.00));
        creditSettingsPrivat.add(new CreditSetting(48,20,12.50));
        creditSettingsPrivat.add(new CreditSetting(60,20,13.00));

        creditSettingsPrivat.add(new CreditSetting(12,30,6.50));
        creditSettingsPrivat.add(new CreditSetting(24,30,10.00));
        creditSettingsPrivat.add(new CreditSetting(36,30,11.00));
        creditSettingsPrivat.add(new CreditSetting(48,30,11.00));
        creditSettingsPrivat.add(new CreditSetting(60,30,11.50));

        creditSettingsPrivat.add(new CreditSetting(12,40,4.50));
        creditSettingsPrivat.add(new CreditSetting(24,40,8.50));
        creditSettingsPrivat.add(new CreditSetting(36,40,9.50));
        creditSettingsPrivat.add(new CreditSetting(48,40,10.00));
        creditSettingsPrivat.add(new CreditSetting(60,40,10.50));

        creditSettingsPrivat.add(new CreditSetting(12,50,1.50));
        creditSettingsPrivat.add(new CreditSetting(24,50,6.00));
        creditSettingsPrivat.add(new CreditSetting(36,50,8.00));
        creditSettingsPrivat.add(new CreditSetting(48,50,8.50));
        creditSettingsPrivat.add(new CreditSetting(60,50,9.00));

        creditSettingsPrivat.add(new CreditSetting(12,60,0.10));
        creditSettingsPrivat.add(new CreditSetting(24,60,3.00));
        creditSettingsPrivat.add(new CreditSetting(36,60,5.00));
        creditSettingsPrivat.add(new CreditSetting(48,60,6.50));
        creditSettingsPrivat.add(new CreditSetting(60,60,7.50));

        creditSettingsPrivat.add(new CreditSetting(12,70,0.10));
        creditSettingsPrivat.add(new CreditSetting(24,70,0.10));
        creditSettingsPrivat.add(new CreditSetting(36,70,0.10));
        creditSettingsPrivat.add(new CreditSetting(48,70,2.50));
        creditSettingsPrivat.add(new CreditSetting(60,70,4.50));

        List<CreditSetting> creditSettingsOshad = new ArrayList<>();
        List<Double> additionalExpensesOshad = new ArrayList<>();
        additionalExpensesOshad.add(1.99);
        creditSettingsOshad.add(new CreditSetting(12,20,8.00));
        creditSettingsOshad.add(new CreditSetting(24,20,1.00));
        creditSettingsOshad.add(new CreditSetting(36,20,12.00));
        creditSettingsOshad.add(new CreditSetting(48,20,14.00));
        creditSettingsOshad.add(new CreditSetting(60,20,14.00));

        creditSettingsOshad.add(new CreditSetting(12,30,6.00));
        creditSettingsOshad.add(new CreditSetting(24,30,8.50));
        creditSettingsOshad.add(new CreditSetting(36,30,10.00));
        creditSettingsOshad.add(new CreditSetting(48,30,11.00));
        creditSettingsOshad.add(new CreditSetting(60,30,12.50));

        creditSettingsOshad.add(new CreditSetting(12,40,4.00));
        creditSettingsOshad.add(new CreditSetting(24,40,7.00));
        creditSettingsOshad.add(new CreditSetting(36,40,8.50));
        creditSettingsOshad.add(new CreditSetting(48,40,10.00));
        creditSettingsOshad.add(new CreditSetting(60,40,12.00));

        creditSettingsOshad.add(new CreditSetting(12,50,1.00));
        creditSettingsOshad.add(new CreditSetting(24,50,5.00));
        creditSettingsOshad.add(new CreditSetting(36,50,7.00));
        creditSettingsOshad.add(new CreditSetting(48,50,9.00));
        creditSettingsOshad.add(new CreditSetting(60,50,10.50));

        creditSettingsOshad.add(new CreditSetting(12,60,0.10));
        creditSettingsOshad.add(new CreditSetting(24,60,2.00));
        creditSettingsOshad.add(new CreditSetting(36,60,4.00));
        creditSettingsOshad.add(new CreditSetting(48,60,7.00));
        creditSettingsOshad.add(new CreditSetting(60,60,8.50));

        creditSettingsOshad.add(new CreditSetting(12,70,0.10));
        creditSettingsOshad.add(new CreditSetting(24,70,0.10));
        creditSettingsOshad.add(new CreditSetting(36,70,0.10));
        creditSettingsOshad.add(new CreditSetting(48,70,3.00));
        creditSettingsOshad.add(new CreditSetting(60,70,5.00));

        List<CreditSetting> creditSettingsUkrGasBank = new ArrayList<>();
        List<Double> additionalExpensesUkrGasBank = new ArrayList<>();
        additionalExpensesUkrGasBank.add(1.50);
        additionalExpensesUkrGasBank.add(2.5);
        creditSettingsUkrGasBank.add(new CreditSetting(12,20,5.00));
        creditSettingsUkrGasBank.add(new CreditSetting(24,20,9.00));
        creditSettingsUkrGasBank.add(new CreditSetting(36,20,10.50));
        creditSettingsUkrGasBank.add(new CreditSetting(60,20,11.50));
        creditSettingsUkrGasBank.add(new CreditSetting(84,20,12.00));

        creditSettingsUkrGasBank.add(new CreditSetting(12,30,3.59));
        creditSettingsUkrGasBank.add(new CreditSetting(24,30,8.00));
        creditSettingsUkrGasBank.add(new CreditSetting(36,30,9.00));
        creditSettingsUkrGasBank.add(new CreditSetting(60,30,10.50));
        creditSettingsUkrGasBank.add(new CreditSetting(83,30,11.50));



        Bank oshadBank = new Bank();
        oshadBank.setNameBank("OshadBank");
        oshadBank.setCreditSettings(creditSettingsOshad);
        oshadBank.setAdditionalExpenses(additionalExpensesOshad);
        Bank PrivatBank = new Bank();
        PrivatBank.setNameBank("PrivatBank");
        PrivatBank.setCreditSettings(creditSettingsPrivat);
        PrivatBank.setAdditionalExpenses(additionalExpenses);
        Bank UkrGasBank = new Bank();
        UkrGasBank.setNameBank("UkrGasBank");
        UkrGasBank.setCreditSettings(creditSettingsUkrGasBank);
        UkrGasBank.setAdditionalExpenses(additionalExpensesUkrGasBank);
        List<Bank> hyndaiBank = new ArrayList<>();
        hyndaiBank.add(UkrGasBank);
        hyndaiBank.add(oshadBank);
        hyndaiBank.add(PrivatBank);
        return hyndaiBank;
    }
}
