package org.sf.company;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class Hello {
    public static void main(String[] args) throws Exception{
//        System.out.println("Hello World!!!");
        invokeDB();
    }

    public static void invokeDB() throws Exception {
        Connection conn = null;
        ResultSet rset = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee", "postgres", "Sonaramanavel@5");
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * from emp");
            while (rset.next()) {
                String s1= rset.getString("name");
                int n= rset.getInt("empno");
                int age= rset.getInt("age");
                int salary= rset.getInt("salary");
                System.out.println("Empno: "+n+" Name: "+s1+" Age: "+age+" Salary: "+salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rset.close();
            stmt.close();
            conn.close();
        }
    }


}
