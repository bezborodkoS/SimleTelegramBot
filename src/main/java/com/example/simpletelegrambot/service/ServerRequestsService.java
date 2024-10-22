package com.example.simpletelegrambot.service;

import com.example.simpletelegrambot.dto.LaunchPoolDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ServerRequestsService {
    public List<LaunchPoolDTO> returnBody(){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<List<LaunchPoolDTO>> responseEntity  = restTemplate.exchange("https://launch-pool-micro-service-d1d34cbb9309.herokuapp.com/api/get/startSoonLaunchPool",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<LaunchPoolDTO>>(){});
        List<LaunchPoolDTO> launchPoolDTOList = responseEntity.getBody();
        return launchPoolDTOList;
    }
}
