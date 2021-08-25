package com.synergyfolks.company;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaconfigDemoApp {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext("sportsconfig.class");

       // Coach theCoach=classPathXmlApplicationContext.getBean("thatSillyCoach",Coach.class);

        Coach theCoach=context.getBean("tennisCoach",Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());

        context.close();
    }
}
