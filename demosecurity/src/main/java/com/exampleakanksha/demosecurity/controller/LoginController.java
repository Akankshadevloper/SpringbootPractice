package com.exampleakanksha.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showingMyLoginPage() {
//        return "plain-login";  // Ensure this matches the file name
        return "fancy-login";
    }
}
