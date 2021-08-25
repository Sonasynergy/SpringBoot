package com.synergyfolks.company;

import com.synergyfolks.company.dao.AccountDAO;
import com.synergyfolks.company.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        MembershipDAO themembershipDAO=context.getBean("membershipDAO",MembershipDAO.class);

        Account myAccount=new Account();
        myAccount.setName("vanish");
        myAccount.setLevel("6th");
        theAccountDAO.addAccount(myAccount,true);
        theAccountDAO.doWork();

        theAccountDAO.setName("sona");
        theAccountDAO.setServicecode("110");

        String name= theAccountDAO.getName();
        String servicecode= theAccountDAO.getServicecode();

        themembershipDAO.addMemberAccount();
        themembershipDAO.goToSleep();

        context.close();

    }
}
