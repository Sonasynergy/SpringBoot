package com.synergyfolks.company.dao;


import com.synergyfolks.company.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + " :  DOING STUFF: ADDING A ACCOUNT");
    }

        public boolean doWork() {
            System.out.println(getClass() +" : Do your work in account");
            return true;
        }
}
