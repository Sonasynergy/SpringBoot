package com.sf.company.UnitTestingSB.UnitTestingSB.controller;


import com.sf.company.UnitTestingSB.controller.StudentRestController;
import com.sf.company.UnitTestingSB.entity.Student;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
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
        assertEquals(8,lists.size());
    }

    @Test
    public void findAllWithNull() throws InterruptedException {
        List<Student> lists=studentRestController.findAll();
        assertNull(lists);
        assertTrue(lists.isEmpty());
    }

    @Test
    public void findById() throws InterruptedException {
        int value=4;
        Student student= (Student) studentRestController.findById(value);
        assertNotNull(student);
        assertEquals(value,student.getId());
    }

    @Test
    public void findByIdWithNull() throws InterruptedException {
        Student student=null;
        student=studentRestController.findById(17);
        assertNull(student);
    }

    @Test
    public void saveStudent() throws InterruptedException {
        Student student=new Student("abc","def","abc@gmail.com");
        Student students=null;
        students=studentRestController.addMarket(student);
        assertEquals(student,students);
        Student email=studentRestController.findEmail(student.getEmail());
        assertEquals(student.getEmail(),email.getEmail());
    }

    @Test
    public void findNull(){
        Student student=null;
        assertThrows(NullPointerException.class,()->{
            studentRestController.addMarket(student);
        });
    }


    @Test
    @DisplayName("Enter your firstName")
    public void firstNameWithNull(){
        Student student=new Student(null,"eee","yyy");
        assertThrows(DataIntegrityViolationException.class,()->{
            studentRestController.addMarket(student);
        });
    }

    @Test
    @DisplayName("Enter your lastName")
    public void lastNameWithNull(){
        Student student=new Student("ram",null,"Ram@gmail.com");
        assertThrows(DataIntegrityViolationException.class,()->{
            studentRestController.addMarket(student);
        });
    }

    @Test
    @DisplayName("Enter your email")
    public void emailWithNull(){
        Student student=new Student("shekar","ram",null);
        assertThrows(DataIntegrityViolationException.class,()->{
            studentRestController.addMarket(student);
        });
    }

    @Test
    public void deleteById(){
        int value=3;
        String actualStudents=null;
        actualStudents=studentRestController.deleteStudent(value);
        assertEquals("Deleted id 3",actualStudents);
    }

}
