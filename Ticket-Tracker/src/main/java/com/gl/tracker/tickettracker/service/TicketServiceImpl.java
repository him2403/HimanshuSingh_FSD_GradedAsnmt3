package com.gl.tracker.tickettracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.tracker.tickettracker.entity.Ticket;
import com.gl.tracker.tickettracker.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public Ticket findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Ticket> result = ticketRepository.findById(theId);
		Ticket theTicket = null;
		if (result.isPresent()) {
			theTicket = result.get();
		} else {
			// we didn't find the Ticket
			throw new RuntimeException("Ticket Not Found with given ticket Number: " + theId);
		}
		return theTicket;
	}

	@Override
	public void save(Ticket theBook) {
		ticketRepository.save(theBook);

	}

	@Override
	public void deleteById(int theId) {
		ticketRepository.deleteById(theId);

	}

	@Override
	public List<Ticket> searchTickets(String keyword) {
		// TODO Auto-generated method stub
		List<Ticket> tickets = ticketRepository.findByTitleContaining(keyword);
		return tickets;
	}

}
