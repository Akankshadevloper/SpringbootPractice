package com.akanksha.demoThymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // Show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // Add a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(@RequestParam("studentName") String studentName, Model model) {
        // Add the received input to the model
        model.addAttribute("message", "Hello, " + studentName + "!");

        // Return the view name
        return "helloWorld";  // Ensure you have a helloWorld.html template
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDube(HttpServletRequest request, Model model) {

        // read the request parameters from the HTML form
        String theName = request.getParameter("studentName");


        //convert the data to all caps
        theName = theName.toUpperCase();


        //create the massage
        String result = "Yo!" + theName + "!";



        //add message to the model
        model.addAttribute("message", result);


        return "helloworld";
    }


    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName,
                                          Model model) {


        //convert the data to all caps
        theName = theName.toUpperCase();


        //create the massage
        String result = "Hey My Friend  " + theName ;



        //add message to the model
        model.addAttribute("message", result);


        return "helloworld";
    }
}
