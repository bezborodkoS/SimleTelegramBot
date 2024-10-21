package com.example.simpletelegrambot;

import java.util.Map;

public class LaunchPoolDTO {
    private String exchange;
    private String launchPool;
    private Map<String, String> pools;
    private String period;
    private String status;

    public LaunchPoolDTO(String exchange, String launchPool, Map<String, String> pools, String period, String status) {
        this.exchange = exchange;
        this.launchPool = launchPool;
        this.pools = pools;
        this.period = period;
        this.status = status;
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
        return String.valueOf(stringBuilder);
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
