package com.sf.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectiondb {
    public static void main(String[] args) {
        String url="jdbc:postgresql://loaclhost:8080/student";
        String userName="postgres";
        String passWord="Sonaramanavel@5";

        try{
            Connection connection= DriverManager.getConnection(url+userName+passWord);
            System.out.println("connection succesfull");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
