package com.sf.company.UnitTestingSB.service;


import com.sf.company.UnitTestingSB.dao.StudentDao;
import com.sf.company.UnitTestingSB.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao=studentDao;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    @Transactional
    public Student findEmail(String email) {
        return studentDao.findEmail(email);
    }

    @Override
    @Transactional
    public Student findById(int theId) {
        return studentDao.findById(theId);
    }

    @Override
    @Transactional
    public Student save(Student students) {
        studentDao.save(students);
        return students;
    }

    @Override
    @Transactional
    public String deleteById(int theId) {
        studentDao.deleteById(theId);
        return null;
    }
}
