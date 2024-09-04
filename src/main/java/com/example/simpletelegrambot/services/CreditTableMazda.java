package com.example.simpletelegrambot.services;

public class CreditTableMazda extends CreditTable {

    @Override
    public double[][] getCostTable() {
        return costTable;
    }

    @Override
    public int[] getMonth() {
        return month;
    }

    private  double[][] costTable = {
            {3.49, 6.99, 8.99, 11.99, 11.99},
            {2.49, 5.99, 8.99, 11.99, 11.99},
            {1.49, 4.99, 7.49, 9.99, 9.99},
            {0.01, 3.99, 5.49, 9.99, 9.99},
            {0.01, 0.01, 4.99, 7.99, 7.99}};
    private  int[] month = {12, 16, 18, 22, 46};


}
