package com.poisonedyouth.ticketmanagementapp.controller;

import com.poisonedyouth.ticketmanagementapp.dao.Person;
import com.poisonedyouth.ticketmanagementapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/all")
	public List<Person> findAllPersons(){
		return personService.findAll();
	}

	@PostMapping("/save")
	public Person saveNewPerson(@RequestBody Person person){
		return personService.save(person);
	}

	@PutMapping("/update")
	public Person updatePerson(@RequestBody Person person){
		Person existingPerson = personService.findById(person.getId());
		existingPerson.setFirstName(person.getFirstName());
		existingPerson.setLastName(person.getLastName());
		existingPerson.setEmail(person.getEmail());
		existingPerson.setAge(person.getAge());
		return personService.save(existingPerson);
	}

	@DeleteMapping("/delete/{id}")
	public void deletePerson(@PathVariable long id){
		Person existingPerson = personService.findById(id);
		personService.delete(existingPerson);
	}

	@GetMapping("/get/{search}")
	public List<Person> findPersonsByLastNameOrEmail(@PathVariable String search){
		return personService.findByLastNameOrEmail(search.toLowerCase());
	}
}
