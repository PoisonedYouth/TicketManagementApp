package com.poisonedyouth.ticketmanagementapp.service;

import com.poisonedyouth.ticketmanagementapp.dao.Person;
import com.poisonedyouth.ticketmanagementapp.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> findAll() {
		return StreamSupport.stream(personRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	public Person save(Person person) {
		return personRepository.save(person);
	}

	public Person findById(long id) {
		Optional<Person> existingPerson = personRepository.findById(id);
		return existingPerson.orElse(null);
	}

	public void delete(Person person) {
		personRepository.delete(person);
	}

	public List<Person> findByLastNameOrEmail(String search) {
		return personRepository.findPersonByLastNameContainingOrEmailContaining(search, search);
	}
}
