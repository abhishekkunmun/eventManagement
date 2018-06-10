package com.abhi.app.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.abhi.app.model.ModelEvent;


@Entity
@Table(name="event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer eventId;
	
	Date registrationDate;
	
	String fullName;
	
	Long mobileNumber;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="event")
	@PrimaryKeyJoinColumn
	Document document;
	
	String email;
		
	String registrationType;
	
	Integer numTickets;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	
	public String getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public Integer getNumTickets() {
		return numTickets;
	}

	public void setNumTickets(Integer numTickets) {
		this.numTickets = numTickets;
	}
	
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	public ModelEvent toModel() {
		ModelEvent modelEvent = new ModelEvent();
		modelEvent.setEventId(eventId);
		modelEvent.setFullName(fullName);
		//modelEvent.setIdCard(idCard);
		modelEvent.setMobileNumber(mobileNumber);
		modelEvent.setNumTickets(numTickets);
		modelEvent.setRegistrationDate(registrationDate);
		List<String> regType = new ArrayList<>();
		regType.add(registrationType);
		modelEvent.setRegistrationType(regType);
		modelEvent.setEmail(email);
		return modelEvent;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
