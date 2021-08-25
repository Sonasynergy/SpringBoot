package com.synergyfolks.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach{

        //init()
    @PostConstruct
    public void doMyinitStuff(){
        System.out.println("init method");
    }
        //destroy()
    @PreDestroy
    public void doMydestroyStuff(){
        System.out.println("destroy method");
    }


    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

//    @Autowired //Constructor inject method
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }


    @Override
    public String getDailyWorkout() {
        return "Practice your backhand valley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

//    @Autowired //Setter inject Method
//    public void setFortuneService(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

//    @Autowired //Setter inject Method
//    public void doSomeCrayStuff(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }
}
