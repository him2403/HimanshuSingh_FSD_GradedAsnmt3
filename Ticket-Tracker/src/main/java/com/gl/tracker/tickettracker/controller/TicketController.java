package com.gl.tracker.tickettracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.tracker.tickettracker.entity.Ticket;
import com.gl.tracker.tickettracker.service.TicketService;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping("/list")
	public String getAllTickets(Model model) {
		List<Ticket> tickets = ticketService.findAll();
		model.addAttribute("tickets", tickets);
		return "ticket/ticket-list";
	}

	@GetMapping("/showTicketFormForAdd")
	public String showTicketFormForAdd(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "ticket/ticket-form";
	}

	@PostMapping("/saveTicket")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		// save the book.
		ticketService.save(ticket);
		// use a redirect to prevent duplicate submissions
		return "redirect:/ticket/list";
	}

	@GetMapping("/showTicketFormForEdit/{id}")
	public String showTicketFormForUpdate(Model model, @PathVariable int id) {
		// Get the ticket from db...
		Ticket ticket = ticketService.findById(id);
		// set ticket as a model attribute to pre-populate the form
		model.addAttribute("ticket", ticket);
		return "ticket/ticket-form";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		// delete the Ticket
		ticketService.deleteById(id);
		// set ticket as a model attribute to pre-populate the form
		return "redirect:/ticket/list";
	}

	@GetMapping("/search")
	public String searchTickets(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
		List<Ticket> matchingTickets = ticketService.searchTickets(keyword);

		model.addAttribute("tickets", matchingTickets);

		return "ticket/search-results";

	}

	@GetMapping("/view/{id}")

	public String viewTicket(@PathVariable int id, Model model) {
		Ticket ticket = ticketService.findById(id);
		model.addAttribute("ticket", ticket);
		return "ticket/view";
	}

}
