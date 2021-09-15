package com.sf.company.UnitTestingSB.dao;


import com.sf.company.UnitTestingSB.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Student> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);
        List<Student> students = theQuery.getResultList();
        return students;
    }

    @Override
    public List<String> findName() {
        Session currentSession = entityManager.unwrap(Session.class);
        NativeQuery res=currentSession.createSQLQuery("select email from Student");
        List<String> results=res.getResultList();
        return results;
    }

    @Override
    public Student findByName(String theName) {
        Session currentSession = entityManager.unwrap(Session.class);
        Student students = currentSession.get(Student.class, theName);
        return students;
    }


    @Override
    public Student findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Student students = currentSession.get(Student.class, theId);
        return students;
    }


    @Override
    public Student save(Student theStudent) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theStudent);
        return theStudent;
    }


    @Override
    public String deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Student where id=:StudentId");
        theQuery.setParameter("StudentId", theId);
        theQuery.executeUpdate();
        return null;
    }

}
