package com.sf.company.UnitTestingSB.UnitTestingSB.dao;


import com.sf.company.UnitTestingSB.dao.StudentDaoImpl;
import com.sf.company.UnitTestingSB.entity.Student;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {

    @Autowired
    private StudentDaoImpl studentDao;

    @Test
    public void findAll() throws InterruptedException {
        List<Student> lists=null;
        int size;
        lists=studentDao.findAll();
        assertNotNull(lists);
        assertEquals(1,lists.size());
    }

    @Test
    public void findById() throws InterruptedException {
        int value=1;
        Student student= (Student) studentDao.findById(value);
        assertNotNull(student.getId());
        assertEquals(value,student.getId());
    }

    @Test
    public void save(){
        Student student=new Student("vanish","prem","prem@gmail.com");
        Student students=null;
        students=studentDao.save(student);
        assertEquals(student,students);
    }

    @Test
    @DisplayName("Enter your firstName")
    public void firstNameWithNull(){
        Student student=new Student(null,"ram","Ram@gmail.com");
        assertThrows(RuntimeException.class,()->{
            studentDao.save(student);
        });
    }

    @Test
    @DisplayName("Enter your lastName")
    public void lastNameWithNull(){
        Student student=new Student("ram",null,"Ram@gmail.com");
        assertThrows(RuntimeException.class,()->{
            studentDao.save(student);
        });
    }

    @Test
    @DisplayName("Enter your email")
    public void emailWithNull(){
        Student student=new Student("shekar","ram",null);
        assertThrows(RuntimeException.class,()->{
            studentDao.save(student);
        });
    }

//    @Test
//    public void delete(){
//        int value=6;
//        String students=null;
//        students=studentDao.deleteById(value);
//        assertEquals(null,students);
//    }

}
