package com.poisonedyouth.ticketmanagementapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAO  extends CrudRepository<Person, Long> {

	List<Person> findPersonByLastName(String lastName);

	List<Person> findPersonByLastNameContainingOrEmailContaining(String lastName, String email);
}
