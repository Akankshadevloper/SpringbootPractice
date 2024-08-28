package com.akanksha.cruddemo.rest;


import com.akanksha.cruddemo.entity.Employee;
import com.akanksha.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // quick and dirty : inject employee dao(use constructor injection )

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }


    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();

        //add mapping for GET / employees / {employeeId}

    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }

        return theEmployee;
    }


    //add mapping for POST /employees - add new employee

    @PostMapping("/employees")

    public Employee addEmployee(@RequestBody Employee theEmployee){

        // also just in case they pass an id in JSON .... set id to 0
        // this is to force a save of new item .... instead of update


        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;

    }

    //add mapping for delete  /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeesId}")
    public String deleteEmployee(@PathVariable int employeesId) {
        Employee tempEmployee = employeeService.findById(employeesId);

        if(tempEmployee == null){
            throw new RuntimeException("Employee not found - " + employeesId);
        }
        employeeService.deleteById(employeesId);

        return "Deleted Employee id -  " + employeesId;
    }
}
























