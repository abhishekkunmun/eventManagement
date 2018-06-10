package com.abhi.app.model;

import java.util.Date;
import java.util.List;

import com.abhi.app.entity.Document;
import com.abhi.app.entity.Event;

public class ModelEvent {

	Integer eventId;
	
	Date registrationDate;
	
	String fullName;
	
	String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	Long mobileNumber;
	
	Document idCard;
	
	List<String> registrationType;
	
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

	
	
	public Integer getNumTickets() {
		return numTickets;
	}

	public void setNumTickets(Integer numTickets) {
		this.numTickets = numTickets;
	}
	
	
	public Event toEntity() {
		Event event = new Event();
		event.setEventId(eventId);
		event.setFullName(fullName);
		event.setDocument(idCard);
		event.setEmail(email);
		event.setMobileNumber(mobileNumber);
		event.setNumTickets(numTickets);
		event.setRegistrationDate(new Date());
		event.setRegistrationType(registrationType.get(0));
		
		return event;
	}

	public Document getIdCard() {
		return idCard;
	}

	public void setIdCard(Document idCard) {
		this.idCard = idCard;
	}

	public List<String> getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(List<String> registrationType) {
		this.registrationType = registrationType;
	}
	
}
