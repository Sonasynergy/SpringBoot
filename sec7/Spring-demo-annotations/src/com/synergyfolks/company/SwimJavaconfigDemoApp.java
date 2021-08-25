package com.synergyfolks.company;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaconfigDemoApp {

    public static void main(String[] args) {


        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(sportsconfig.class);

        // get the bean from spring container
//        Coach theCoach = context.getBean("swimCoach", Coach.class);
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call method to get the daily fortune
        System.out.println(theCoach.getDailyFortune());

        System.out.println(theCoach.getEmail());
        System.out.println(theCoach.getTeam());
        // close the context
        context.close();
    }
}
