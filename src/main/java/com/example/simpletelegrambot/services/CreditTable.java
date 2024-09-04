package com.example.simpletelegrambot.services;

public abstract class CreditTable {

    private double[][] costTable;
    private int[] month;

    public double[][] getCostTable() {
        return costTable;
    }

    public int[] getMonth() {
        return month;
    }
}
