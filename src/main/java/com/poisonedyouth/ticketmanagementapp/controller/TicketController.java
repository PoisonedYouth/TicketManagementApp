package com.poisonedyouth.ticketmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poisonedyouth.ticketmanagementapp.dao.Person;
import com.poisonedyouth.ticketmanagementapp.dao.Ticket;
import com.poisonedyouth.ticketmanagementapp.service.TicketService;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/all")
	public List<Ticket> findAllTickets(){
		return ticketService.findAll();
	}
	
	@PutMapping("/update")
	public Ticket updateTicket(@RequestBody Ticket ticket){
		Ticket existingTicket = ticketService.findById(ticket.getId());
		existingTicket.setEventDate(ticket.getEventDate());
		existingTicket.setOwner(ticket.getOwner());
		existingTicket.setPrize(ticket.getPrize());
		existingTicket.setTitle(ticket.getTitle());
		return existingTicket;
	}

	@DeleteMapping("/delete/{id}")
	public void deletePerson(@PathVariable long id){
		Ticket existingTicket = ticketService.findById(id);
		ticketService.delete(existingTicket);
	}

	@GetMapping("/get/{search}")
	public List<Ticket> findByOwner(@PathVariable Person search){
		return ticketService.findByOwner(search);
	}

}
