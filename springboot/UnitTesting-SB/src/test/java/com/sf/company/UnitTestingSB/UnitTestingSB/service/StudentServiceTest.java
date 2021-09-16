package com.sf.company.UnitTestingSB.UnitTestingSB.service;

import com.sf.company.UnitTestingSB.entity.Student;
import com.sf.company.UnitTestingSB.service.StudentServiceImpl;
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
public class StudentServiceTest {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @Test
    public void findAll() throws InterruptedException {
        List<Student> lists=null;
        int size;
        lists=studentServiceImpl.findAll();
        assertNotNull(lists);
        assertFalse(lists.isEmpty());
        assertEquals(8,lists.size());
    }

    @Test
    public void findAllWithNull() throws InterruptedException {
        List<Student> lists=studentServiceImpl.findAll();
        assertNull(lists);
        assertTrue(lists.isEmpty());
    }

    @Test
    public void findById() throws InterruptedException {
        int value=1;
        Student student= (Student) studentServiceImpl.findById(value);
        assertNotNull(student.getId());
        assertEquals(value,student.getId());
    }

    @Test
    public void findByIdWithNull() throws InterruptedException {
        Student student=null;
        student=studentServiceImpl.findById(17);
        assertNull(student);
    }

    @Test
    public void saveStudent() throws InterruptedException {
        Student student=new Student("abc","def","abc@gmail.com");
        Student students=null;
        students=studentServiceImpl.save(student);
        assertEquals(student,students);
        Student email=studentServiceImpl.findEmail(student.getEmail());
        assertEquals(student.getEmail(),email.getEmail());
    }

    @Test
    public void findNull(){
        Student student=null;
        assertThrows(NullPointerException.class,()->{
            studentServiceImpl.save(student);
        });
    }

    @Test
    @DisplayName("Enter your firstName")
    public void firstNameWithNull(){
        Student student=new Student(null,"ram","Ram@gmail.com");
        assertThrows(DataIntegrityViolationException.class,()->{
            studentServiceImpl.save(student);
        });
    }

    @Test
    @DisplayName("Enter your lastName")
    public void lastNameWithNull(){
        Student student=new Student("ram",null,"Ram@gmail.com");
        assertThrows(DataIntegrityViolationException.class,()->{
            studentServiceImpl.save(student);
        });
    }

    @Test
    @DisplayName("Enter your email")
    public void emailWithNull(){
        Student student=new Student("shekar","ram",null);
        assertThrows(DataIntegrityViolationException.class,()->{
            studentServiceImpl.save(student);
        });
    }

    @Test
    public void delete(){
        int value=5;
        String students=null;
        students=studentServiceImpl.deleteById(value);
        assertEquals(null,students);
    }

}
