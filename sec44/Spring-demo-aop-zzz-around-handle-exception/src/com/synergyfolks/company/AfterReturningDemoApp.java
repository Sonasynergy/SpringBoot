package com.synergyfolks.company;

import com.synergyfolks.company.dao.AccountDAO;
import com.synergyfolks.company.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> myaccounts= theAccountDAO.findAccount(false);

        System.out.println("=======>  After Returning Demo");
        System.out.println(myaccounts);

        context.close();

    }
}
