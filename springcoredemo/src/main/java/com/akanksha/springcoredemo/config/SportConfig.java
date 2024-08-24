package com.akanksha.springcoredemo.config;

import com.akanksha.springcoredemo.common.Coach;
import com.akanksha.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
