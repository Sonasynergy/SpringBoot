package com.sf.company.UnitTestingSB.service;

import com.sf.company.UnitTestingSB.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();

    public List<String> findName();

    public Student findByName(String name);

    public Student findById(int theId);

    public Student save(Student theMarket);

    public String deleteById(int theId);
}
