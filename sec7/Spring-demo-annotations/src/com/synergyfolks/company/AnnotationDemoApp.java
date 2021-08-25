package com.synergyfolks.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {


        ClassPathXmlApplicationContext classPathXmlApplicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");

       // Coach theCoach=classPathXmlApplicationContext.getBean("thatSillyCoach",Coach.class);

        Coach theCoach=classPathXmlApplicationContext.getBean("tennisCoach",Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyFortune());

        classPathXmlApplicationContext.close();
    }
}
