package com.example.simpletelegrambot.service;

import java.io.*;
import java.util.List;

public class FileWriterAndReaderService {


    public static final String CASH_FILE = "cash.txt";

    public void createFile() {
        try {
            File file = new File(CASH_FILE);
            if (file.createNewFile()) {
                System.out.println("create file");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + "create");
            throw new RuntimeException(e);
        }

    }


//    Записывает в файл сколько раз exchange, launchPool, period
    public void writeFile(String simpleLaunchPoolInCash) {
        String line = null;
        createFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CASH_FILE))) {
            line = bufferedReader.readLine();
            if (line==null||line.isEmpty()){
                line = simpleLaunchPoolInCash;
            }else if (!line.contains(simpleLaunchPoolInCash)){
                line = line+", "+simpleLaunchPoolInCash;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(CASH_FILE)) {
            fileOutputStream.write(line.getBytes());
        } catch (IOException e) {
            System.out.println("FileOutputStream " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


//    считывает линию с файла и возрощает ее
    public String readFile() {
        createFile();
        String s = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CASH_FILE))) {
//            if (bufferedReader.readLine()!=null) {
                s = bufferedReader.readLine();
//            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + " read");
        }
        return s;
    }

}
