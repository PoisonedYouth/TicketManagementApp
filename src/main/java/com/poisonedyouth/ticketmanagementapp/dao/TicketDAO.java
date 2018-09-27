package com.poisonedyouth.ticketmanagementapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDAO extends CrudRepository<Ticket, Long> {
	
	List<Ticket> findTicketByOwner(Person owner);
}
