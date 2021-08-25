package com.synergyfolks.company.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune() {

        // simulate a delay

        try {

            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // return a fortune
        return "Expect heavy traffic this morning";

    }


    public String getFortune(boolean tripWire) throws Exception {
        if(tripWire){
            throw new Exception("Major accident");
        }
        return "Expect heavy traffic this morning";
    }
}
