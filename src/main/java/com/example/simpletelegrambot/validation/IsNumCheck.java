package com.example.simpletelegrambot.validation;

public class IsNumCheck implements Validator {

    private static final String RESP_MESS = " Не вірний формат вводу значення, має бути число, без зайвих символів. Проблеми  з наступним полем ->";

    @Override
    public boolean check(String[] inputDataMass) {
        for (String dataMass : inputDataMass) {
            if (!isNum(dataMass)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getMess() {
        return RESP_MESS;
    }

    private boolean isNum(String inputNum) {
        try {
            Integer.parseInt(inputNum);
            return true;
        } catch (NumberFormatException ex) {
            return false;

        }
    }
}
