package com.synergyfolks.company;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    private String[] arr={ "hello","hi","awesome"};

    private Random random=new Random();


    @Override
    public String getFortune() {
        int i= random.nextInt(arr.length);
        String theFortune=arr[i];
        return theFortune;
    }
}
