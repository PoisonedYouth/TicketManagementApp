package com.poisonedyouth.ticketmanagementapp.service;

import com.poisonedyouth.ticketmanagementapp.dao.Person;
import com.poisonedyouth.ticketmanagementapp.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonService {

	@Autowired
	private PersonDAO personDAO;

	public List<Person> findAll() {
		return StreamSupport.stream(personDAO.findAll().spliterator(), false).collect(Collectors.toList());
	}

	public Person save(Person person) {
		return personDAO.save(person);
	}

	public Person findById(long id) {
		Optional<Person> existingPerson = personDAO.findById(id);
		return existingPerson.orElse(null);
	}

	public void delete(Person person) {
		personDAO.delete(person);
	}

	public List<Person> findByLastNameOrEmail(String search) {
		return personDAO.findPersonByLastNameContainingOrEmailContaining(search, search);
	}
}
