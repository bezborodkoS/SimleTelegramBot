package com.example.simpletelegrambot.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationProcessor {

    private final List<Validator> validatorList = new ArrayList<>();

    private static final String ERROR_TEXT = "Не вдалося отримати данні для обробки";

    public ValidationProcessor() {
        validatorList.add(new ParamCountCheck());
        validatorList.add(new IsNumCheck());
    }

    public String validate(String text) {
        String warningText = "";
        String[] inputDataMass = text.split("\n");
        if (inputDataMass.length != 0) {
            for (Validator validator : validatorList) {
                boolean isValidation = validator.check(inputDataMass);
                if (!isValidation) {
                    warningText = validator.getMess();
                    System.out.println(warningText);
                    break;
                }
            }
        } else {
            warningText = ERROR_TEXT;
        }
        return warningText;
    }
}
