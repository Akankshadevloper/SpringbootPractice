package com.akanksha.demoThymeleaf.controller;


import com.akanksha.demoThymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${systems}")
    private List<String> systems;




    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {



        //create a new student object
        Student theStudent = new Student();


        //add student object to the model
        theModel.addAttribute("student", theStudent);

        //add the list of language to the model
        theModel.addAttribute("countries", countries);

        //add the list of systems to the model
        theModel.addAttribute("systems", systems);


        return "student-form";
    }


    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        System.out.println("theStudent:" + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }

}



























