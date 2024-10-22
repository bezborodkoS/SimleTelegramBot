package com.example.simpletelegrambot.service;

import com.example.simpletelegrambot.dto.LaunchPoolDTO;

import java.util.ArrayList;
import java.util.List;

public class UpdateCashFile {
    private FileWriterAndReaderService fileWriterAndReaderService = new FileWriterAndReaderService();
//    private ServerRequestsService serverRequestsService;


    public List<LaunchPoolDTO> showLaunchPoolListStartSoon(){

        List<LaunchPoolDTO> launchPoolDTOList = new ServerRequestsService().returnBody();
        List<LaunchPoolDTO> launchPoolDTONoShow = new ArrayList<>();
        List<String> cashPool = List.of(fileWriterAndReaderService.readFile().split(", "));


            for (LaunchPoolDTO launch : launchPoolDTOList) {
                String s = "";


//                TODO переделать
//                проверям есть ли в файле такой launchPool по  exchange, launchPool, period. После єтого берем из найденой строки количество раз которіе мі уже віводили
//                После єтого присваиваем launchPool.countShow последнее количество последних распечаток
                for (int i = cashPool.size()-1; i >= 0; i--) {
                    if (cashPool.get(i).contains(launch.simpleLaunchPoolNoTakeCountShow())){
                        s = cashPool.get(i);
                        launch.setCountShow(Integer.parseInt(s.substring(0,1))+1);
                        System.out.println(launch.getCountShow()+" count show");
                        break;
                    }
                }

                if (launch.getCountShow() <= 4) {
                    if (!cashPool.contains(launch.simpleLaunchPoolInCash())) {
                    launch.setCountShow(launch.getCountShow() + 1);
                    }
                    fileWriterAndReaderService.writeFile(launch.simpleLaunchPoolInCash());
                    launchPoolDTONoShow.add(launch);
                }
            }

        return launchPoolDTONoShow;
    }

}
