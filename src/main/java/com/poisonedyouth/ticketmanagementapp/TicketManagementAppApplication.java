package com.poisonedyouth.ticketmanagementapp;

import com.poisonedyouth.ticketmanagementapp.dao.Person;
import com.poisonedyouth.ticketmanagementapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketManagementAppApplication implements CommandLineRunner {

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(TicketManagementAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Doe");
		person.setAge(18);
		person.setEmail("john.doe@mail.com");
		personService.save(person);
		Person person2 = new Person();
		person2.setFirstName("Max");
		person2.setLastName("Cavalera");
		person2.setAge(45);
		person2.setEmail("max.cavalera@mail.com");
		personService.save(person2);
		Person person3 = new Person();
		person3.setFirstName("Hans");
		person3.setLastName("Wurst");
		person3.setAge(32);
		person3.setEmail("hans.wurst@mail.com");
		personService.save(person3);
	}
}
