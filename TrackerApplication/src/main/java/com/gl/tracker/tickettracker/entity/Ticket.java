package com.gl.tracker.tickettracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "ticket_title")
	private String title;
	@Column(name = "description")
	private String desc;
	private String tidketdate;
	private String assignee;

	public Ticket(String title, String desc, String tidketdate, String assignee) {
		super();
		this.title = title;
		this.desc = desc;
		this.tidketdate = tidketdate;
		this.assignee = assignee;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTicketdate() {
		return tidketdate;
	}

	public void setTicketdate(String tidketdate) {
		this.tidketdate = tidketdate;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

}
