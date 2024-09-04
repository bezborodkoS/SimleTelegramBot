package com.example.simpletelegrambot.services;


import java.util.ArrayList;
import java.util.List;

public class CarCredit {

    List<CreditTable> creditTables = new ArrayList<>();

    public CarCredit() {
        this.creditTables.add(new CreditTableToyota());
        this.creditTables.add(new CreditTableMazda());
    }

    //    private final double[][] costTableReno= {
//            {3.49, 6.99, 8.99, 11.99, 11.99},
//            {2.49, 5.99, 8.99, 11.99, 11.99},
//            {1.49, 4.99, 7.49, 9.99, 9.99},
//            {0.01, 3.99, 5.49, 9.99, 9.99},
//            {0.01, 0.01, 4.99, 7.99, 7.99}};
//    private final int[] monthReno = {12, 24, 36, 48, 60};


//    private final double[][] costTableMazda = {
//            {3.49, 6.99, 8.99, 11.99, 11.99},
//            {2.49, 5.99, 8.99, 11.99, 11.99},
//            {1.49, 4.99, 7.49, 9.99, 9.99},
//            {0.01, 3.99, 5.49, 9.99, 9.99},
//            {0.01, 0.01, 4.99, 7.99, 7.99}};
//    private final int[] monthMazda = {12, 24, 36, 48, 60};


//    public void tableOut() {
//        System.out.println("Initial pay %\t" + "Term of credit, monthly pay %");
//        for (int i = 0; i < costTable.length; i++) {
//            System.out.print("\t" + (i + 3) * 10 + "%\t\t\t");
//            for (int j = 0; j < costTable[i].length; j++) {
//                System.out.print(costTable[i][j] + "\t");
//            }
//            System.out.println();
//        }
//    }
//
//    public void carPay(double totalCost) {
//        System.out.println("Initial pay %\t" + "Term of credit, monthly pay %");
//        System.out.println("\t\t\t12 mon.\t24 mon.\t36 mon.\t48 mon.\t60 mon.");
//        for (int i = 0; i < costTable.length; i++) {
//            System.out.print((totalCost/10*(i+3)) + "\t");
//            for (int j = 0; j < costTable[i].length; j++) {
//                System.out.print(Math.ceil((totalCost/10*(i+3))/month[j]*(costTable[i][j]/100)+(totalCost/10*(i+3))/month[j]) + "\t");
//            }
//            System.out.println();
//        }
//    }
//
//    public void carPay(double totalCost, double initialPay){
//        int lowDiff = 0;
//        for (int i = 1; i < 5; i++)
//            if (Math.abs(totalCost/10*(i+3)) < Math.abs(totalCost/10*(lowDiff+3)))
//                lowDiff = i;
//        if (initialPay != (totalCost/10*(lowDiff+3)))
//            System.out.println("Initial pay of " + initialPay + " is not found. The closest initial pay you can make is: " + (totalCost/10*(lowDiff+3)));
//        System.out.println("Initial pay %\t" + "Term of credit, monthly pay %");
//        System.out.println("\t\t\t12 mon.\t24 mon.\t36 mon.\t48 mon.\t60 mon.");
//        System.out.print((totalCost/10*(lowDiff+3)) + "\t");
//        for (int i = 0; i < costTable[lowDiff].length; i++) {
//            System.out.print(Math.ceil(totalCost/10*(lowDiff+3)/month[i]*(costTable[lowDiff][i]/100)+totalCost/10*(lowDiff+3)/month[i]) + "\t");
//        }
//        System.out.println();
//    }

//    CreditTableToyotaInitial pay % Term of credit, monthly pay %
//
//            12mon. 24mon. 36mon. 48mon. 60mon.
//300000.0 25873.0 13374.0 9083.0 7000.0 5600.0
//    CreditTableMazdaInitial pay % Term of credit, monthly pay %
//
//            12mon. 16mon. 18mon. 22mon. 46mon.
//300000.0 25873.0 20061.0 18165.0 15272.0 7304.0
    public String carPay(double totalCost, double initialPay, double monthlyPay) {
        String response = "";
        for (CreditTable creditTable : creditTables) {
            response = response + creditTable.getClass().getSimpleName() + carPayLogic(totalCost, initialPay, monthlyPay, creditTable);
        }
        return response;
    }

    public String carPayLogic(double totalCost, double initialPay, double monthlyPay, CreditTable creditTable) {
        double[][] costTable = creditTable.getCostTable();
        int[] month = creditTable.getMonth();


        int lowDiff = 0;
        int lowDiff2 = 0;
        StringBuilder result = new StringBuilder();  // Для накопичення результату

        // Знаходження найближчого початкового платежу
        for (int i = 1; i < 5; i++) {
            if (Math.abs(totalCost / 10 * (i + 3)) < Math.abs(totalCost / 10 * (lowDiff + 3))) {
                lowDiff = i;
            }
        }

        if (initialPay != (totalCost / 10 * (lowDiff + 3))) {
            result.append("Initial pay of ").append(initialPay)
                    .append(" is not found. The closest initial pay you can make is: ")
                    .append(totalCost / 10 * (lowDiff + 3)).append("\n");
        }

        result.append("Initial pay %\t").append("Term of credit, monthly pay %").append("\n\n");

        // Знаходження найближчого щомісячного платежу
        for (int i = 1; i < 5; i++) {
            if (Math.abs(Math.ceil(totalCost / 10 * (lowDiff + 3) / month[i] * (costTable[lowDiff][i] / 100) +
                    totalCost / 10 * (lowDiff + 3) / month[i]) - monthlyPay) <
                    Math.abs(Math.ceil(totalCost / 10 * (lowDiff + 3) / month[lowDiff2] * (costTable[lowDiff][lowDiff2] / 100) +
                            totalCost / 10 * (lowDiff + 3) / month[lowDiff2]) - monthlyPay)) {
                lowDiff2 = i;
            }
        }

        // Формування строк з терміном кредиту
        for (int i = 0; i < 5; i++) {
            if (i == lowDiff2) {
                result.append("\t").append(month[i]).append("mon.");
            } else {
                result.append("\t").append(month[i]).append("mon.");
            }
        }
        result.append("\n");

        // Формування рядка з початковим платежем та відповідними щомісячними платежами
        result.append(totalCost / 10 * (lowDiff + 3)).append("\t");

        for (int i = 0; i < costTable[lowDiff].length; i++) {
            if (i == lowDiff2) {
                result.append(Math.ceil(totalCost / 10 * (lowDiff + 3) / month[i] * (costTable[lowDiff][i] / 100) +
                        totalCost / 10 * (lowDiff + 3) / month[i])).append("\t");
            } else {
                result.append(Math.ceil(totalCost / 10 * (lowDiff + 3) / month[i] * (costTable[lowDiff][i] / 100) +
                        totalCost / 10 * (lowDiff + 3) / month[i])).append("\t");
            }
        }
        result.append("\n");

        // Повертаємо зібраний результат у вигляді String
        return result.toString();
    }

//    public void carPay(double totalCost, double initialPay, double monthlyPay){
//        int lowDiff = 0;
//        int lowDiff2 = 0;
//        for (int i = 1; i < 5; i++)
//            if (Math.abs(totalCost/10*(i+3)) < Math.abs(totalCost/10*(lowDiff+3)))
//                lowDiff = i;
//        if (initialPay != (totalCost/10*(lowDiff+3)))
//            System.out.println ("Initial pay of " + initialPay + " is not found. The closest initial pay you can make is: " + (totalCost/10*(lowDiff+3)));
//        System.out.println  ("Initial pay %\t" + "Term of credit, monthly pay %");
//        System.out.println ("\t\t");
//
//        for (int i = 1; i < 5; i++) {
//            if (Math.abs(Math.ceil(totalCost/10*(lowDiff+3)/month[i]*(costTable[lowDiff][i]/100)+
//                    totalCost/10*(lowDiff+3)/month[i])-monthlyPay) <
//                    Math.abs(Math.ceil(totalCost/10*(lowDiff+3)/month[lowDiff2]*(costTable[lowDiff][lowDiff2]/100)+
//                            totalCost/10*(lowDiff+3)/month[lowDiff2])-monthlyPay))
//                lowDiff2 = i;
//        }
//
//        for (int i = 0; i < 5; i++) {
//            if (i == lowDiff2) {
//                 System.out.print("\t" + month[i] + "mon."  );
//            } else{ System.out.print("\t" + month[i] + "mon.");}
//        }
//        System.out.println();
//        System.out.print((totalCost/10*(lowDiff+3)) + "\t");
//        for (int i = 0; i < costTable[lowDiff].length; i++) {
//            if (i == lowDiff2) {
//                  System.out.print(Math.ceil(totalCost/10*(lowDiff+3)/month[i]*(costTable[lowDiff][i]/100)+totalCost/10*(lowDiff+3)/month[i]) + "\t");
//            } else {
//                System.out.print(Math.ceil(totalCost / 10 * (lowDiff + 3) / month[i] * (costTable[lowDiff][i] / 100) + totalCost / 10 * (lowDiff + 3) / month[i]) + "\t");
//            }
//        }
//        System.out.println();
//    }

    private String costCounter(double cost, double percent) {
        cost = round(cost * percent);
        String shortCost;
        if (cost < 1000)
            shortCost = cost + "";
        else if (cost < 1000000)
            shortCost = cost + "k";
        else shortCost = cost + "m";
        return shortCost;
    }

    private double round(double number) {
        number *= 10;
        number = (int) number;
        number /= 10;
        return number;
    }

}
