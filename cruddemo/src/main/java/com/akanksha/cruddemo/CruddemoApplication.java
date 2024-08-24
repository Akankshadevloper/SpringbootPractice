package com.akanksha.cruddemo;

import com.akanksha.cruddemo.dao.StudentDAO;
import com.akanksha.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			creatStudent(studentDAO);
		};
	}

	private void creatStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object.....");
		Student tempStudent = new Student("Akanksha","Kumari","akanksha@gmail.com");


		//save the student object
		System.out.println("Saving the student ....");
		studentDAO.save(tempStudent);


		//display the id of the saved student
		System.out.println("Saved the student . Generate id: " + tempStudent.getId());
	}

}

















