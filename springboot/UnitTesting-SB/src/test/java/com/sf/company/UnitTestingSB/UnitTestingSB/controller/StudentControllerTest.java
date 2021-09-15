package com.sf.company.UnitTestingSB.UnitTestingSB.controller;


import com.sf.company.UnitTestingSB.controller.StudentRestController;
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
public class StudentControllerTest {

    @Autowired
    private StudentRestController studentRestController;

    @Test
    public void findAll() throws InterruptedException {
        List<Student> lists=null;
        int size;
        lists=studentRestController.findAll();
        assertNotNull(lists);
        assertFalse(lists.isEmpty());
        assertEquals(2,lists.size());
    }

    @Test
    public void findById() throws InterruptedException {
        int value=3;
        Student student= (Student) studentRestController.findById(value);
        assertNotNull(student.getId());
        assertEquals(value,student.getId());
    }

    @Test
    public void save(){
        Student student=new Student("priya","ram","priya@gmail.com");
        Student students=null;
        students=studentRestController.addMarket(student);
        assertEquals(student,students);
    }

    @Test
//    @DisplayName("Enter your firstName")
    public void firstNameWithNull(){
        Student student=new Student(null,"ram","Ram@gmail.com");
        assertThrows(RuntimeException.class,()->{
            studentRestController.addMarket(student);
        });
    }

    @Test
    @DisplayName("Enter your lastName")
    public void lastNameWithNull(){
        Student student=new Student("ram",null,"Ram@gmail.com");
        assertThrows(RuntimeException.class,()->{
            studentRestController.addMarket(student);
        });
    }

    @Test
    @DisplayName("Enter your email")
    public void emailWithNull(){
        Student student=new Student("shekar","ram",null);
        assertThrows(RuntimeException.class,()->{
            studentRestController.addMarket(student);
        });
    }

    @Test
    public void deleteById(){
        int value=3;
        String students=null;
        students=studentRestController.deleteMarket(value);
        assertEquals("Deleted id 3",students);
    }


}
