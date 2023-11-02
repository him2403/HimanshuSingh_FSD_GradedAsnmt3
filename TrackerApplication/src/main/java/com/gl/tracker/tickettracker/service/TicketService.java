package com.gl.tracker.tickettracker.service;

import java.util.List;

import com.gl.tracker.tickettracker.entity.Ticket;

public interface TicketService {
	
	public List<Ticket> findAll();

	public Ticket findById(int theId);
	
	public List<Ticket> searchTickets(String keyword);

	public void save(Ticket theBook);

	public void deleteById(int theId);


	

}
