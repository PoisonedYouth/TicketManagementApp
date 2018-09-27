package com.poisonedyouth.ticketmanagementapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poisonedyouth.ticketmanagementapp.dao.Person;
import com.poisonedyouth.ticketmanagementapp.dao.Ticket;
import com.poisonedyouth.ticketmanagementapp.dao.TicketDAO;

@Service
public class TicketService {

	@Autowired
	private TicketDAO ticketDAO;
	
	public List<Ticket> findAll() {
		return StreamSupport.stream(ticketDAO.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	public Ticket findById(long id) {
		Optional<Ticket> existingTicket = ticketDAO.findById(id);
		return existingTicket.orElse(null);
	}

	public void delete(Ticket ticket) {
		ticketDAO.delete(ticket);
	}

	public List<Ticket> findByOwner(Person owner) {
		return ticketDAO.findTicketByOwner(owner);
	}
}
