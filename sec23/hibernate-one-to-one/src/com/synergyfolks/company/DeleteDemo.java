package com.synergyfolks.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

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

            // create the objects

			Instructor tempInstructor =
					new Instructor("Chad", "Darby", "darby@luv2code.com");

			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.luv2code.com/youtube",
							"Luv 2 code!!!");


            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);
            session.beginTransaction();
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

            // get instructor by primary key / id
            int theId = 1;
            Instructor tempInstructor1 =
                    session.get(Instructor.class, theId);

            System.out.println("Found instructor: " + tempInstructor1);

            // delete the instructors
            if (tempInstructor1 != null) {

                System.out.println("Deleting: " + tempInstructor);

                // Note: will ALSO delete associated "details" object
                // because of CascadeType.ALL
                //
                session.delete(tempInstructor1);
            }

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
