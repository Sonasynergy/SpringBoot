package com.synergyfolks.company;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class WelcomeBean {

    private String msg;

    public void init(){
        System.out.println("init method");
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void getMsg() {
        System.out.println(msg);
    }

    public void show(){
        System.out.println(msg);
    }

    public void destroy(){
        System.out.println("destroy");
    }
}
