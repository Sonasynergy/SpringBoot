package com.synergyfolks.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int theId=4;

           session.beginTransaction();

           InstructorDetail tempinstructorDetail=session.get(InstructorDetail.class,theId);

            System.out.println("tempinstructorDetail: "+tempinstructorDetail);

            System.out.println("the associated instructor: "+tempinstructorDetail.getInstructor());

            System.out.println("Deleting tempInstructorDetail: " + tempinstructorDetail);

            tempinstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tempinstructorDetail);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
