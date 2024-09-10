package com.akankshaluvtocode.aopdemo;

import com.akankshaluvtocode.aopdemo.dao.AccountDAO;
import com.akankshaluvtocode.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO , MembershipDAO theMembershipDAO) {

		return runner -> {

			demoTheBeforeAdvice(theAccountDAO , theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		//call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount , true);


		//call the membership business method
		theMembershipDAO.addSillyMember();


//		//do it again
//		System.out.println("\n let's call it again \n ");
//
//
//		//call the business method again
//		theAccountDAO.addAccount();
	}
}







