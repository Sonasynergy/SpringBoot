package com.synergyfolks.company;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() {
    }


    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Justo do it "+ fortuneService.getFortune();
    }

    public void doMyStartupStuff(){
        System.out.println("TrackCoach doMyStartupStuff");
    }

    public void doMyCleanStuff(){
        System.out.println("TrackCoach doMyCleanStuff");
    }
}
