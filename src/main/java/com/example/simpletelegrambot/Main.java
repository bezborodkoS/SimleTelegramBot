package com.example.simpletelegrambot;

import com.example.simpletelegrambot.dto.LaunchPoolDTO;
import com.example.simpletelegrambot.service.FileWriterAndReaderService;
import com.example.simpletelegrambot.service.UpdateCashFile;

public class Main {
    public static void main(String[] args) {
//        FileWriterAndReaderService fileWriterAndReaderService = new FileWriterAndReaderService();
        UpdateCashFile updateCashFile = new UpdateCashFile();
        System.out.println(updateCashFile.showLaunchPoolListStartSoon().size()+" size");
        for (LaunchPoolDTO launch: updateCashFile.showLaunchPoolListStartSoon()) {
            System.out.println("POOLSHOW");
            System.out.println(launch.poolsShow(launch));
        }


    }
}
