package com.synergyfolks.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext=
                new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");

        Coach theCoach=classPathXmlApplicationContext.getBean("myCoach",Coach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        classPathXmlApplicationContext.close();

    }
}
