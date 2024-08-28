package com.akanksha.cruddemo.dao;

import com.akanksha.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {


    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);


    void deleteById(int theId);
}
