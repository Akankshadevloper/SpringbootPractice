package com.akanksha.springcoredemo.rest;


import com.akanksha.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {

    //define a private field for the dependency

    private Coach myCoach;

//    private Coach anotherCoach;

    //define a constructor for dependency injection
//    @Autowired
//    public DemoController(Coach coach) {
//        myCoach = coach;
//    }


    @Autowired
    public void DemoController(@Qualifier("aquatic") Coach theCoach)
//                               @Qualifier("cricketCoach")Coach theAnotherCoach)
                              {
        System.out.println("In constructor : " + getClass().getSimpleName());
        myCoach = theCoach;
//        anotherCoach = theAnotherCoach;
    }



    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

//    @GetMapping("/check")
//    public String check() {
//        return "Comparing beans : myCoach == anotherCoach " + (myCoach == anotherCoach);
//    }

}


//@Qualifier("trackCoach")