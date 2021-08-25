package com.synergyfolks.company;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");

//        WelcomeBean welcomeBean=context.getBean("id1",WelcomeBean.class);
//
//        welcomeBean.show();


//        Resource res=new ClassPathResource("applicationContext.xml");
//        BeanFactory beanFactory=new XmlBeanFactory(res);
//        WelcomeBean welcomeBean= (WelcomeBean) beanFactory.getBean("id1");
//        welcomeBean.show();

        //Scope
        WelcomeBean welcomeBean=context.getBean("id1",WelcomeBean.class);
        welcomeBean.setMsg("Hello hi");
        welcomeBean.getMsg();

        WelcomeBean welcomeBean1=context.getBean("id1",WelcomeBean.class);
        welcomeBean1.setMsg("Hello hi guys");
        welcomeBean1.getMsg();

        context.close();



    }
}
