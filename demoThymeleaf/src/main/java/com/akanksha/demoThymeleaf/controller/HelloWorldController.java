package com.akanksha.demoThymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
