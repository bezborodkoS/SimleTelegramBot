package com.example.simpletelegrambot;

public class SpecialMethods {

    public int returnRandomNumb(){
        return (int) (Math.random()*10);
    }

    public int showRandomNumberEvery5Second() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            return returnRandomNumb();
        }
        return -1;
    }
}
