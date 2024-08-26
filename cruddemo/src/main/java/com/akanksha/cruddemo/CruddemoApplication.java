package com.akanksha.cruddemo;

import com.akanksha.cruddemo.dao.StudentDAO;
import com.akanksha.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			creatStudent(studentDAO);

			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudent(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students ");
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println("Delete row count : " + numRowDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 4;
		System.out.println("Deleting student id : " +studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id : " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to "Scooby"
		System.out.println("Update student ...");
		myStudent.setFirstName("akanksha");

		//update the student
		studentDAO.update(myStudent);


		//display the update student
		System.out.println("Update student : " + myStudent);


	}

	private void queryForStudent(StudentDAO studentDAO) {

		//get a list of student
		List<Student> theStudents = studentDAO.findAll();

		//display list of student
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating new student object ...... ");
		Student tempStudent = new Student("Daffy","Duck","deffy@gmail.com");


		//save the student
		System.out.println("Saving the student ....");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student : Generate id: " + theId);


		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id : " + theId);
		Student myStudent = studentDAO.findById(theId);


		//display student
		System.out.println("Found the student  : " + myStudent);
	}



	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students

		System.out.println("Creating 3 student object.....");
		Student tempStudent1 = new Student("Bibek","Behera","behera@gmail.com");
		Student tempStudent2 = new Student("Ashish","Kumar","ashish@gmail.com");
		Student tempStudent3 = new Student("Satvinder","Sheni","sattu@gmail.com");

		//save the student
		System.out.println("Saving student object.....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
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

















