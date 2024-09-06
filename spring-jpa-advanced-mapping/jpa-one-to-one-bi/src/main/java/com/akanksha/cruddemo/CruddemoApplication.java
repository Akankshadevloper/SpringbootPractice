package com.akanksha.cruddemo;

import com.akanksha.cruddemo.dao.AppDAO;
import com.akanksha.cruddemo.entity.Instructor;
import com.akanksha.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner  -> {
//			createInstructor(appDAO);

//			findInstructor(appDAO);

//			deleteInstructor(appDAO);


//			findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInsInstructorById(theId);
		System.out.println("Done!");

	}

	private void findInstructorDetail(AppDAO appDAO) {

		//get the instructor detail object
		int theId = 1;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		//print the instructor detail
		System.out.println("tempInstructorDetail = " + tempInstructorDetail);

		//print the associate instructor
		System.out.println("the associate instructor :  " + tempInstructorDetail.getInstructor());

		System.out.println("Done!!");
	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Deleting instructor id: " + theId);


		appDAO.deleteInsInstructorById(theId);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 3;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor =  appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetails only : " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
/*
		// Create the instructor
		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@gmail.com");

		// Create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://www.luv2code.com/youtube",
				"Luv to Code!!");

*/

		// Create the instructor
		Instructor tempInstructor = new Instructor("Bibek", "Behera", "ak@gmail.com");

		// Create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://www.luv2codemadhu.com/youtube",
				"Doing Sketch");


		// Associate the objects correctly
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// Save the instructor
		//
		// NOTE: this will also save the instructorDetail object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}

