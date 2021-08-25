package com.synergyfolks.company;

public class BaseBallCoach implements Coach{

    private FortuneService fortuneService;

    public BaseBallCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 minutes on batting pratice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
