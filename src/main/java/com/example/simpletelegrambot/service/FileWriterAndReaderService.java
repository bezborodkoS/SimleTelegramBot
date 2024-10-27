package com.example.simpletelegrambot.service;

import java.io.*;

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
        String line;
        createFile();
        line = readFile();
        if (line == null || line.isEmpty()) {
            line = simpleLaunchPoolInCash;
        } else if (!line.contains(simpleLaunchPoolInCash)) {
            line = line + ", " + simpleLaunchPoolInCash;
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
        String s = null;
//        createFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CASH_FILE))) {
            s = bufferedReader.readLine();
            if (s == null) {
                s = "";
            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + " read");
        }
        return s;
    }

}
