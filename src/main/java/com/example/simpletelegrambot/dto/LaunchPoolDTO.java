package com.example.simpletelegrambot.dto;

import java.util.Map;

public class LaunchPoolDTO {
    private String exchange;
    private String launchPool;
    private Map<String, String> pools;
    private String period;
    private String status;

    private int countShow;

    public LaunchPoolDTO(String exchange, String launchPool, Map<String, String> pools, String period, String status) {
        this.exchange = exchange;
        this.launchPool = launchPool;
        this.pools = pools;
        this.period = period;
        this.status = status;
        this.countShow = 0;
    }

    public int getCountShow() {
        return countShow;
    }

    public void setCountShow(int countShow) {
        this.countShow = countShow;
    }

    public String getExchange() {
        return exchange;
    }

    public String getLaunchPool() {
        return launchPool;
    }

    public Map<String, String> getPools() {
        return pools;
    }

    public String getPeriod() {
        return period;
    }

    public String getStatus() {
        return status;
    }
    
    public String poolsShow(LaunchPoolDTO launchPoolDTO){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(launchPoolDTO.getExchange() + ": " + launchPoolDTO.getLaunchPool() +
                "\n period= " + launchPoolDTO.getPeriod() +
                "\n status= " + launchPoolDTO.getStatus() + "\n");
        for (Map.Entry<String, String> map : launchPoolDTO.pools.entrySet()) {
            stringBuilder.append(map.getKey()+": "+map.getValue()+"\n");
        }
        return stringBuilder.toString();
    }

    public String simpleLaunchPoolNoTakeCountShow(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(exchange).append(" ").append(launchPool).append(" ").append(period);
        return stringBuilder.toString();
    }

    public String simpleLaunchPoolInCash(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(countShow).append("-").append(exchange).append(" ").append(launchPool).append(" ").append(period);
        return stringBuilder.toString();
    }
    

    @Override
    public String toString() {
        return  exchange + ": " + launchPool +
                "\n period= " + period +
                "\n status= " + status + "\n" +
                pools+"\n"
                ;
    }
}
