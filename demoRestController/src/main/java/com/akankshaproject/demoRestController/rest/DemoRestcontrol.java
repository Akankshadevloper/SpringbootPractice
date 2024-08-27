package com.akankshaproject.demoRestController.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestcontrol {

    //add code for the "/hello" endpoint

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
