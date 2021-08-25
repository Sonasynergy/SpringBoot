package com.sf.springboot.thymeleafdemo.dao;

import com.sf.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeJpaRepository extends JpaRepository<Employee,Integer> {

    public List<Employee> findAllByOrderByLastNameAsc();
}
