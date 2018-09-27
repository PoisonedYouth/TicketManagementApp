package com.poisonedyouth.ticketmanagementapp;

import com.poisonedyouth.ticketmanagementapp.dao.Person;
import com.poisonedyouth.ticketmanagementapp.dao.Ticket;
import com.poisonedyouth.ticketmanagementapp.service.PersonService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketManagementAppApplication implements CommandLineRunner{

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(TicketManagementAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person person1 = createPerson("Bob", "Doe", "bob.doe@mail.com", 56);
		Person person2 = createPerson("Max", "Mustermann", "max.mustermann@mail.com", 12);
		
		List<Ticket> tickets = new ArrayList<>();
		tickets.add(createTicket(person1, LocalDate.now(), "Holy Shit", 23.3));
		tickets.add(createTicket(person1,LocalDate.now(), "Back to the roots", 59.99));
		person1.setTickets(tickets);
		personService.save(person1);
		
		tickets = new ArrayList<>();
		tickets.add(createTicket(person2, LocalDate.now(), "Holy Shit", 23.3));
		tickets.add(createTicket(person2, LocalDate.now(), "Back to the roots", 59.99));
		person2.setTickets(tickets);
		personService.save(person2);
		
	}
	
	private Person createPerson(String firstName, String lastName, String email, int age) {
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setEmail(email);
		person.setAge(age);
		return person;
	}
	
	private Ticket createTicket(Person owner, LocalDate eventDate, String title, double prize) {
		Ticket ticket = new Ticket();
		ticket.setEventDate(eventDate);
		ticket.setTitle(title);
		ticket.setPrize(prize);
		ticket.setOwner(owner);
		return ticket;
	}
}
