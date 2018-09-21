package com.poisonedyouth.ticketmanagementapp.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository  extends CrudRepository<Person, Long> {

	List<Person> findPersonByLastName(String lastName);

	List<Person> findPersonByLastNameContainingOrEmailContaining(String lastName, String email);
}
