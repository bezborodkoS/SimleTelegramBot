package com.example.simpletelegrambot.dealer;

import com.example.simpletelegrambot.model.Bank;
import com.example.simpletelegrambot.model.CreditSetting;

import java.util.ArrayList;
import java.util.List;

public class Kia extends AutoDealer{
    public Kia() {
        this.nameAutoDealer = "Kia";
        this.bankList = bankKia();
    }

    private List<Bank> bankKia(){

        List<CreditSetting> creditSettingsOshad = new ArrayList<>();
        List<Double> additionalExpenses = new ArrayList<>();
        additionalExpenses.add(2.5);
        additionalExpenses.add(1.99);

        creditSettingsOshad.add(new CreditSetting(12,20,7.49));
        creditSettingsOshad.add(new CreditSetting(24,20,11.49));
        creditSettingsOshad.add(new CreditSetting(36,20,11.99));
        creditSettingsOshad.add(new CreditSetting(60,20,13.49));
        creditSettingsOshad.add(new CreditSetting(84,20,14.49));

        creditSettingsOshad.add(new CreditSetting(12,30,6.99));
        creditSettingsOshad.add(new CreditSetting(24,30,10.49));
        creditSettingsOshad.add(new CreditSetting(36,30,11.49));
        creditSettingsOshad.add(new CreditSetting(60,30,12.49));
        creditSettingsOshad.add(new CreditSetting(83,30,13.49));

        List<CreditSetting> creditSettingsVipAvto = new ArrayList<>();
        List<Double> additionalExpensesVipAvto = new ArrayList<>();
        additionalExpensesVipAvto.add(1.99);
        creditSettingsVipAvto.add(new CreditSetting(12,20,5.49));
        creditSettingsVipAvto.add(new CreditSetting(24,20,8.49));
        creditSettingsVipAvto.add(new CreditSetting(36,20,11.49));
        creditSettingsVipAvto.add(new CreditSetting(60,20,12.49));
        creditSettingsVipAvto.add(new CreditSetting(84,20,13.49));

        creditSettingsVipAvto.add(new CreditSetting(12,30,3.99));
        creditSettingsVipAvto.add(new CreditSetting(24,30,7.49));
        creditSettingsVipAvto.add(new CreditSetting(36,30,19.49));
        creditSettingsVipAvto.add(new CreditSetting(60,30,11.49));
        creditSettingsVipAvto.add(new CreditSetting(83,30,12.49));

        List<CreditSetting> creditSettingsMyEnergy = new ArrayList<>();
        List<Double> additionalExpensesMyEnergy = new ArrayList<>();
        additionalExpensesMyEnergy.add(1.50);
        additionalExpensesMyEnergy.add(2.5);
        creditSettingsMyEnergy.add(new CreditSetting(12,20,5.00));
        creditSettingsMyEnergy.add(new CreditSetting(24,20,9.00));
        creditSettingsMyEnergy.add(new CreditSetting(36,20,10.50));
        creditSettingsMyEnergy.add(new CreditSetting(60,20,11.50));
        creditSettingsMyEnergy.add(new CreditSetting(84,20,12.00));

        creditSettingsMyEnergy.add(new CreditSetting(12,30,3.59));
        creditSettingsMyEnergy.add(new CreditSetting(24,30,8.00));
        creditSettingsMyEnergy.add(new CreditSetting(36,30,9.00));
        creditSettingsMyEnergy.add(new CreditSetting(60,30,10.50));
        creditSettingsMyEnergy.add(new CreditSetting(83,30,11.50));


        
        Bank oshadBank = new Bank();
        oshadBank.setNameBank("OshadBank");
        oshadBank.setCreditSettings(creditSettingsOshad);
        oshadBank.setAdditionalExpenses(additionalExpenses);
        Bank MyEnergyBank = new Bank();
        MyEnergyBank.setNameBank("MyEnergyBank");
        MyEnergyBank.setCreditSettings(creditSettingsOshad);
        MyEnergyBank.setAdditionalExpenses(additionalExpenses);
        Bank VipCarBank = new Bank();
        VipCarBank.setNameBank("VipCarBank");
        VipCarBank.setCreditSettings(creditSettingsOshad);
        VipCarBank.setAdditionalExpenses(additionalExpenses);
        List<Bank> kiaBank = new ArrayList<>();
        kiaBank.add(VipCarBank);
        kiaBank.add(oshadBank);
        kiaBank.add(MyEnergyBank);
        return kiaBank;
    }
}
