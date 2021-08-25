package com.synergyfolks.company.dao;


import com.synergyfolks.company.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String servicecode;

    public String getName() {
        System.out.println("GetName");
        return name;
    }

    public void setName(String name) {
        System.out.println("SetName");
        this.name = name;
    }

    public String getServicecode() {
        System.out.println("GetServicecode");
        return servicecode;
    }

    public void setServicecode(String servicecode) {
        System.out.println("SetServicecode");
        this.servicecode = servicecode;
    }

    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + " :  DOING STUFF: ADDING A ACCOUNT");
    }

    public boolean doWork() {
            System.out.println(getClass() +" : Do your work in account");
            return true;
    }

    public List<Account> findAccount(){

        List<Account> accounts=new ArrayList<>();
        Account account1=new Account("sona","silver");
        Account account2=new Account("vanish","gold");
        Account account3=new Account("priya","crystal");
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        return accounts;

    }

}
