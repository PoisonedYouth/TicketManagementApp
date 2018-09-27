package com.poisonedyouth.ticketmanagementapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poisonedyouth.ticketmanagementapp.service.PersonService;

@Controller
@RequestMapping("/")
public class PersonMvcController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("persons")
	public String getAllPersons(Model model) {
		model.addAttribute("persons", personService.findAll());
		return "persons";
	}
	
}
