package com.akanksha.cruddemo;

import com.akanksha.cruddemo.dao.AppDAO;
import com.akanksha.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner  -> {

//			createCourseAndStudent(appDAO);

//			findCourseAndStudent(appDAO);

//			findStudentAndCourses(appDAO);

//			addMoreCoursesForStudent(appDAO);

//			deleteCourse(appDAO);

			deleteStudent(appDAO);


		};
	}

	private void deleteStudent(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting student id: " + theId);

		appDAO.deleteStudentById(theId);

		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCourseByStudentId(theId);


		//create more course
		Course tempCourse1 = new Course("Rubik's cube - How to speed Cube ");
		Course tempCourse2 = new Course("Atari 2600 - Game Development  ");

		//add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Updating student: " + tempStudent);
		System.out.println("associated courses: " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {

		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCourseByStudentId(theId);

		System.out.println("Loaded student : " + tempStudent);
		System.out.println("Courses: " + tempStudent.getCourses());

		System.out.println("Done!");
	}

	private void findCourseAndStudent(AppDAO appDAO) {

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded course : " + tempCourse);
		System.out.println("Students : " + tempCourse.getStudents());

		System.out.println("Done!");
	}

	private void createCourseAndStudent(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Pacman -  How to score One Million Points ");

		//create the students
		Student tempStudent1 = new Student("Akanksha " , "Kumari","akkumari@gmail.com");
		Student tempStudent2 = new Student("Bibek " , "Behera","bibekbehera@gmail.com");

		//add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);


		//save the course and associate students
		System.out.println("Saving the Course : " + tempCourse);
		System.out.println("Associated student:  " + tempCourse.getStudents());

		appDAO.save(tempCourse);

		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;
		System.out.println("Deleting course id:  " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		//get the course and reviews

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		//print the course
		System.out.println();


		//print the reviews
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!");

	}

	private void createCourseAndReviews(AppDAO appDAO) {

		//create a course
		Course tempCourse = new Course("Pacman - How to sore one Million Points ");

		//add some reviews
		tempCourse.addReview(new Review("Great course.....loved it!"));
		tempCourse.addReview(new Review("Cool course.....job well done.!"));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));


		//save the course ... and leverage the cascade all
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());


		appDAO.save(tempCourse);

		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		//find the course
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		//update the course
		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("Enjoy the simple things  ");

		appDAO.update(tempCourse);

		System.out.println("Done!");
	}


	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		//find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		//update the instructor
		System.out.println("Updating instructor id: " + theId);
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		//find the instructor
		System.out.println("Finding instructor id : " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor : " + tempInstructor);
		System.out.println("the associated courses : " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Find Instructor id : " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor : " + tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		//associate the object
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Find Instructor id : " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor : " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// Create the instructor
		Instructor tempInstructor = new Instructor("Bibek", "Behera", "Bibekbk@gmail.com");

		// Create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://www.youtube.com",
				"Playing Basketball");


		// Associate the objects correctly
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide ");
		Course tempCourse2 = new Course("The Pinball MasterClass ");

		//add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save the instructor

		//Note this will also save the courses
		//because the CascadeType.PERSIST
		System.out.println("Saving Instructor" + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done !!!!");

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

		int theId = 1;
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

