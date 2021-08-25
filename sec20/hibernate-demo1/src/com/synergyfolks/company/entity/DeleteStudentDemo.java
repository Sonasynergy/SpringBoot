package com.synergyfolks.company.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();


        try{

            int studentId = 1;

        // now get a new session and start transaction
        session = factory.getCurrentSession();

            Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
            Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");


            session.beginTransaction();

            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

        // retrieve student based on the id: primary key
        System.out.println("\nGetting student with id: " + studentId);

        Student myStudent = session.get(Student.class, studentId);

         //delete the student
         System.out.println("Deleting student: " + myStudent);
         session.delete(myStudent);

        // delete student id=2
//        System.out.println("Deleting student id=2");

        session.createQuery("delete from Student where id=2").executeUpdate();

        // commit the transaction
        session.getTransaction().commit();

        System.out.println("Done!");
    }
    finally {
            factory.close();
        }
    }
}
