package com.example.simpletelegrambot.service;

import com.example.simpletelegrambot.dto.LaunchPoolDTO;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class UpdateCashFile {
    public static final int HOUR_START = 6;
    public static final int HOUR_END = 18;
    private FileWriterAndReaderService fileWriterAndReaderService = new FileWriterAndReaderService();
    private ServerRequestsService serverRequestsService = new ServerRequestsService();


    public List<LaunchPoolDTO> showLaunchPoolListStartSoon() {

        List<LaunchPoolDTO> launchPoolDTOList = serverRequestsService.returnStartSoonLaunchPools();
        List<LaunchPoolDTO> launchPoolDTONoShow = new ArrayList<>();

/*      Создаем List для строки считаной с файла.
        Объявляем строку и присваимаем ей значения с считаного файла.
        Проверяем есть ли в строке хоть что-то, если есть то разбиваем нашу строку на подстроки и записываем их в List.
        Если же нет, то просто создаем пустой List.     */
        List<String> cashPool;
        String readFileString = fileWriterAndReaderService.readFile();
        if (readFileString != null) {
            cashPool = List.of(readFileString.split(", "));
        } else {
            cashPool = new ArrayList<>();
        }
/*      Перебираем обьекты которые нам пришли.
        Если в нашем файле уже есть такой обьект то пропускаем, если есть то вписываем в файл и ложим в Lis который возращаем   */
        for (LaunchPoolDTO launch : launchPoolDTOList) {
            if (!cashPool.contains(launch.simpleLaunchPoolInCash()) && checkTime()) {
                fileWriterAndReaderService.writeFile(launch.simpleLaunchPoolInCash());
                launchPoolDTONoShow.add(launch);
            }
        }

        return launchPoolDTONoShow;
    }

    public List<LaunchPoolDTO> showActiveLaunchPools() {
        return serverRequestsService.returnActiveLaunchPools();
    }


    public boolean checkTime() {
        int hourNow = LocalTime.now().getHour();
        if (hourNow >= HOUR_START && hourNow <= HOUR_END) {
            return true;
        }
        return false;
    }
}
