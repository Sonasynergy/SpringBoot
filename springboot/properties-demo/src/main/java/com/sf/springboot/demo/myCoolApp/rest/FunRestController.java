package com.sf.springboot.demo.myCoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teamInfo")
    public String getTeamInfo(){
        return "CoachName: "+coachName+",TeamName: "+teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "HelloWorld!!!"+ LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "run 5k";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";
    }

}
