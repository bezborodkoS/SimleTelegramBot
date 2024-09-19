package com.example.simpletelegrambot.model;

import java.util.ArrayList;
import java.util.List;


public class CarDealer {

    private String nameCarDealer;



    private ArrayList<Bank> banks;

    public CarDealer(String nameCarDealer, ArrayList<Bank> banks) {
        this.nameCarDealer = nameCarDealer;
        this.banks = banks;
    }

    public void setNameCarDealer(String nameCarDealer) {
        this.nameCarDealer = nameCarDealer;
    }

    public void setBanks(ArrayList<Bank> banks) {
        this.banks = banks;
    }

    public String getNameCarDealer() {
        return nameCarDealer;
    }

    public List<Bank> getBanks() {
        return banks;
    }
}
