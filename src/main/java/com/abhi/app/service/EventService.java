package com.abhi.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abhi.app.entity.Event;
import com.abhi.app.exception.ServiceException;
import com.abhi.app.model.ModelEvent;
import com.abhi.app.repository.EventRepository;

@Component
public class EventService {

	@Autowired
	EventRepository eventRepo;
	

	public ModelEvent fetchEventById(Integer id) throws ServiceException {
		Optional<Event> event = eventRepo.findById(id);
		if(!event.isPresent())
			throw new ServiceException("No Event with Id "+id+" found");
		return event.get().toModel();
	}
	
	public ModelEvent addEvent(ModelEvent modelEvent) throws ServiceException {
		Event event = modelEvent.toEntity();
		event.getDocument().setEvent(event);
		eventRepo.saveAndFlush(event);
		return event.toModel();
	}
	
	public List<ModelEvent> fetchAllEvents() throws ServiceException {
		List<Event> events = eventRepo.findAll();
		List<ModelEvent> modelEvents = new ArrayList<>();
		for(Event event:events) {
			modelEvents.add(event.toModel());
		}
		return modelEvents;
	}

	public void deleteEventById(Integer id) throws ServiceException {
		Optional<Event> event = eventRepo.findById(id);
		if(!event.isPresent())
			throw new ServiceException("No Event with Id "+id+" found");
		eventRepo.delete(event.get());
	}
	
}
