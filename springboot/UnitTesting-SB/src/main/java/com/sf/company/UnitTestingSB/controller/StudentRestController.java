package com.sf.company.UnitTestingSB.controller;

import com.sf.company.UnitTestingSB.entity.Student;
import com.sf.company.UnitTestingSB.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @Autowired
    private StudentService studentService;


    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> findAll() throws InterruptedException {
        return studentService.findAll();
    }

    @GetMapping("/student/{studentId}")
    public Student findById(@PathVariable int studentId) throws InterruptedException {
        return studentService.findById(studentId);
    }

    @GetMapping("/students/name")
    public Student findEmail(String email) throws InterruptedException {
        return studentService.findEmail(email);
    }

    @PostMapping("/students")
    public Student addMarket(@RequestBody Student thestudent) {
//        thestudent.setId(0);
        studentService.save(thestudent);
        return thestudent;
    }

    @PutMapping("/students")
    public Student updateMarket(@RequestBody Student thestudent) {
        studentService.save(thestudent);
        return thestudent;
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        Student tempmarket = studentService.findById(studentId);
        if (tempmarket == null) {
            throw new RuntimeException("student id not found - " + studentId);
        }
        studentService.deleteById(studentId);
        return "Deleted id " + studentId;
    }
}
