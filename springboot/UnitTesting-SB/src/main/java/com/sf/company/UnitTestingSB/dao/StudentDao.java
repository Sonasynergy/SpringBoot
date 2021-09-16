package com.sf.company.UnitTestingSB.dao;

import com.sf.company.UnitTestingSB.entity.Student;

import java.util.List;

public interface StudentDao {

    public List<Student> findAll();

    public Student findEmail(String email);

    public Student findByName(String name);

    public Student findById(int theId);

    public Student save(Student theMarket);

    public String deleteById(int theId);
}
