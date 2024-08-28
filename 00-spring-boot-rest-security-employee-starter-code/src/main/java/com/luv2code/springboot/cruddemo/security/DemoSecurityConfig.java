package com.luv2code.springboot.cruddemo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    //add support for JDBC .... no more hardcoded users :-)


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET , "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET , "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST , "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT , "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE , "/api/employees/**").hasRole("ADMIN")
        );

        //USE HTTP BASIC AUTHENTICATION
        http.httpBasic(Customizer.withDefaults());

        //disable Cross Site Request Forgery (CSRF)

        //IN GENERAL , NOT REQUIRED FOR STATELESS REST APIs THAT USE POST , PUT , DELETE AND/OR PATCH
        http.csrf(csrf -> csrf.disable());


        return http.build();
    }


    /*
    @Bean
    public InMemoryUserDetailsManager UserDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();


        UserDetails marry = User.builder()
                .username("marry")
                .password("{noop}test123")
                .roles("EMPLOYEE" , "MANAGER")
                .build();



        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER" , "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, marry, susan);

    }
*/

}
