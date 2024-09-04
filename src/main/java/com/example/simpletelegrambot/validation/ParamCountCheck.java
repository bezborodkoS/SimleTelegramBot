package com.example.simpletelegrambot.validation;

public class ParamCountCheck implements Validator {
    private static final String RESP_MESS = " Не правильна кількість вхідних данних. Має бути 3 поля: \n" +
            " -вартість авто \n" +
            " -першорчерговий внесок \n " +
            " -сума щомісячного платіжа" +
            "";
    @Override
    public boolean check( String[] inputDataMass) {
        if (inputDataMass.length != 3) {
            return false;
        }
        return true;
    }

    @Override
    public String getMess() {
        return RESP_MESS;
    }
}
