package com.akankshaproject.demoRestController.rest;


import com.akankshaproject.demoRestController.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //define @PostConstruct to load the student data ... only once !

    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Akanksha", "Kumari"));
        theStudents.add(new Student("Bibek", "Behera"));
        theStudents.add(new Student("Rakhi", "Kumari"));

    }
    //define endpoint for "/student" - return a list of student

    @GetMapping("/students")
    public List<Student> getStudents() {



        return theStudents;
    }

    //define endpoint or "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // just index into the list... keep it simple for now


        //check the studentId again list size
        if( (studentId >= theStudents.size()) || (studentId < 0) ) {
            throw new StudentNotFoundException("Student with id " + studentId + " not found");
        }

        return theStudents.get(studentId);
    }

    //Add an exception handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        //create a studentErrorResponse

        StudentErrorResponse error = new StudentErrorResponse();


        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());


        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}


















