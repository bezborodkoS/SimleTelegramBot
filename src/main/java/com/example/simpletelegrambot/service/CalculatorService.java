package com.example.simpletelegrambot.service;


import com.example.simpletelegrambot.dto.CreditSettingDTO;
import com.example.simpletelegrambot.dealer.MazdaAutoDealer;
import com.example.simpletelegrambot.dealer.ToyotaAutoDealer;
import com.example.simpletelegrambot.model.Bank;
import com.example.simpletelegrambot.model.CreditSetting;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {


    //    start:  /buyCar
    //  покупка автомобиля с месячным платежом пользователя который он может себе позволить
    public ArrayList<CreditSettingDTO> canBuyCar(Double costCar, Double deposit, Double wantPayInMonth, String nameAutoDealer) {
        Integer calculateDepositPercent = (int) (deposit / (costCar / 100));

        calculateDepositPercent = foundPercentDepositFromCostCar(calculateDepositPercent, autoDealerCreditSettings(nameAutoDealer));
        ArrayList<CreditSettingDTO> transformationToObjArrayList = returnAllPurchaseOptionsCarWithWantPayInMonth(costCar, deposit, calculateDepositPercent, wantPayInMonth, nameAutoDealer);
        return transformationToObjArrayList;
    }


    //    вернуть список всех возможных вариантов кредита с месячным платежом пользователя который он может себе позволить
    private ArrayList<CreditSettingDTO> returnAllPurchaseOptionsCarWithWantPayInMonth(Double costCar, Double deposit, Integer calculateDepositPercent, Double wantPayInMonth, String nameAutoDealer) {
//        List<CreditSetting> foundAllVersionsWhizSpecificsPercentDeposit = takeAllSettingsInNeadAutoDealer(nameAutoDealer,wantPayInMonth,costCar,deposit);


        ArrayList<CreditSettingDTO> transformationToObjArrayList = takeAllSettingsInNeadAutoDealer(nameAutoDealer, wantPayInMonth, costCar, deposit, calculateDepositPercent);
        ;
        return transformationToObjArrayList;
    }

    //    поиск подходящих кредитов
    private static ArrayList<CreditSettingDTO> takeAllSettingsInNeadAutoDealer(String nameAutoDealer, double wantPay, double costCar, double deposit, int calculatePercentDeposit) {
        ArrayList<CreditSettingDTO> creditSettingDtoList = new ArrayList<>();
        double costCarAfterPayDeposit = calculateCostCarAfterPayDeposit(costCar, deposit);
//        int calculPercentDeposit =
        List<Bank> banks = null;
        if (nameAutoDealer.toLowerCase().equals("toyota")) {
            ToyotaAutoDealer toyotaAutoDealer = new ToyotaAutoDealer();
            banks = toyotaAutoDealer.getCarDealer().getBanks();
        } else if (nameAutoDealer.toLowerCase().equals("mazda")) {

            MazdaAutoDealer mazdaAutoDealer = new MazdaAutoDealer();
            banks = mazdaAutoDealer.getCarDealer().getBanks();
            System.out.println(banks.size());
        }
        for (Bank bank : banks) {
            for (int i = 0; i < bank.getCreditSettings().size(); i++) {
                    double calculateMonthlyPayment = calculateMonthlyPayment(bank.getCreditSettings().get(i), costCarAfterPayDeposit);
                    if (wantPay >= calculateMonthlyPayment && bank.getCreditSettings().get(i).getPercentDeposit() == calculatePercentDeposit) {
                        CreditSettingDTO creditSettingDto = new CreditSettingDTO().convertCreditSettingToDTO(bank.getCreditSettings().get(i), nameAutoDealer);
                        creditSettingDto.setMonthlyPayment(calculateMonthlyPayment);
                        creditSettingDtoList.add(creditSettingDto);
                    }

                }
            }
        return creditSettingDtoList;
    }

//    end:   /buyCar


    //    найти процент первого взноса от общей стоимости всей машины
    private Integer foundPercentDepositFromCostCar(Integer calculateDepositPercent, ArrayList<CreditSetting> creditSettings) {
        List<CreditSetting> creditSettingList = creditSettings;
        for (int i = 0; i < creditSettingList.size(); i++) {
            if (i != creditSettingList.size() - 1) {
                if (calculateDepositPercent >= creditSettingList.get(i).getPercentDeposit() && calculateDepositPercent < creditSettingList.get(i + 1).getPercentDeposit()) {
                    calculateDepositPercent = creditSettingList.get(i).getPercentDeposit();
                    return calculateDepositPercent;
                }
            } else {
                calculateDepositPercent = creditSettingList.get(i).getPercentDeposit();
            }
        }
        return calculateDepositPercent;
    }

    //    вернуть список всех вариантов кредита по названию автосалона
    private static ArrayList<CreditSetting> autoDealerCreditSettings(String nameAutoDealer) {
        List<CreditSetting> creditSettingList = new ArrayList<>();
        if (nameAutoDealer.toLowerCase().equals("toyota")) {
            ToyotaAutoDealer toyotaAutoDealer = new ToyotaAutoDealer();
            List<Bank> banks = toyotaAutoDealer.getCarDealer().getBanks();

            for (Bank bank : banks) {
                for (CreditSetting creditSetting : bank.getCreditSettings()) {
                    creditSettingList.add(creditSetting);
                }
            }
        }
        return (ArrayList<CreditSetting>) creditSettingList;
    }

    //    Расчитать месячный платеж
    private static double calculateMonthlyPayment(CreditSetting t, double costCarAfterPayDeposit) {
        return (costCarAfterPayDeposit + (costCarAfterPayDeposit / t.getPercent())) / t.getMonth();
    }

    //    расчитать оставшуюся стоимость машины после вычета депозита
    private static double calculateCostCarAfterPayDeposit(Double costCar, Double deposit) {
        return costCar - deposit;
    }
}
