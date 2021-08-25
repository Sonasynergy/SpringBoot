package com.synergyfolks.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext=
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        Coach theCoach=classPathXmlApplicationContext.getBean("myCoach",Coach.class);
        Coach theAlphaCoach=classPathXmlApplicationContext.getBean("myCoach",Coach.class);

        boolean res=(theCoach==theAlphaCoach);
        System.out.println(res);
        System.out.println(theCoach);
        System.out.println(theAlphaCoach);

        classPathXmlApplicationContext.close();

    }
}
