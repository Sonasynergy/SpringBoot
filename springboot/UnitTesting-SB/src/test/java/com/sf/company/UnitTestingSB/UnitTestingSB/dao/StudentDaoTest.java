package com.sf.company.UnitTestingSB.UnitTestingSB.dao;


import com.sf.company.UnitTestingSB.dao.StudentDaoImpl;
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
public class StudentDaoTest {

    @Autowired
    private StudentDaoImpl studentDao;

    @Test
    public void findAll() throws InterruptedException {
        List<Student> lists=null;
        int size;
        lists=studentDao.findAll();
        assertNotNull(lists);
        assertFalse(lists.isEmpty());
        assertEquals(8,lists.size());
    }

    @Test
    public void findAllWithNull() throws InterruptedException {
        List<Student> lists=studentDao.findAll();
        assertNull(lists);
        assertTrue(lists.isEmpty());
    }

    @Test
    public void findById() throws InterruptedException {
        int studentId = 1;
        Student student = studentDao.findById(studentId);
        assertNotNull(student);
        assertEquals(studentId,student.getId());
    }

    @Test
    public void findByIdWithNull() throws InterruptedException {
        Student student=null;
        student=studentDao.findById(17);
        assertNull(student);
    }

    @Test
    public void saveStudent() throws InterruptedException {
        Student student=new Student("abc","def","abc@gmail.com");
        Student students=null;
        students=studentDao.save(student);
        assertEquals(student,students);
        Student email=studentDao.findEmail(student.getEmail());
        assertEquals(student.getEmail(),email.getEmail());
    }

    @Test
    public void findNull(){
        Student student=null;
        assertThrows(NullPointerException.class,()->{
            studentDao.save(student);
        });
    }

    @Test
    @DisplayName("Enter your firstName")
    public void firstNameWithNull(){
        Student student=new Student(null,"ram","Ram@gmail.com");
        assertThrows(DataIntegrityViolationException.class,()->{
            studentDao.save(student);
        });
    }

    @Test
    @DisplayName("Enter your lastName")
    public void lastNameWithNull(){
        Student student=new Student("ram",null,"Ram@gmail.com");
        assertThrows(DataIntegrityViolationException.class,()->{
            studentDao.save(student);
        });
    }

    @Test
    @DisplayName("Enter your email")
    public void emailWithNull(){
        Student student=new Student("shekar","ram",null);
        assertThrows(DataIntegrityViolationException.class,()->{
            studentDao.save(student);
        });
    }

    @Test
    public void delete(){
        int value=6;
        String students=null;
        students=studentDao.deleteById(value);
        assertEquals(null,students);
    }

}
