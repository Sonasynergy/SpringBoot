package com.synergyfolks.company;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;
    private String emailAddress;
    private String team;

    public CricketCoach() {
        System.out.println("No arg constructor");
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Setter Method");
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("Setter Method-email");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("Setter Method-team");
        this.team = team;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
