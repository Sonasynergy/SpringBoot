package com.synergyfolks.company;

import com.synergyfolks.company.dao.AccountDAO;
import com.synergyfolks.company.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Main Program");
        String data=trafficFortuneService.getFortune();

        System.out.println(data);
        context.close();

    }
}
