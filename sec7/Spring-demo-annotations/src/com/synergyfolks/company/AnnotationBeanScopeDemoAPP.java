package com.synergyfolks.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoAPP {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach=classPathXmlApplicationContext.getBean("tennisCoach",Coach.class);
        Coach theAlphaCoach=classPathXmlApplicationContext.getBean("tennisCoach",Coach.class);


        boolean flag=(theCoach==theAlphaCoach);
        System.out.println(flag);

        classPathXmlApplicationContext.close();
    }
}
