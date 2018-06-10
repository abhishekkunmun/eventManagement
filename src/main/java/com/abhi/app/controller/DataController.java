package com.abhi.app.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abhi.app.entity.Document;
import com.abhi.app.exception.ServiceException;
import com.abhi.app.model.ModelEvent;
import com.abhi.app.service.DocumentService;
import com.abhi.app.service.EventService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DataController {

	@Autowired
	EventService eventService;
	
	@Autowired
	DocumentService documentService;
	
	
	@CrossOrigin
	@PostMapping(value="/events", headers = "Content-Type= multipart/form-data")
	public ModelEvent addEvents(@RequestParam("modelEvent") String data, @RequestParam("file") MultipartFile file) throws ServiceException, JsonParseException, JsonMappingException, IOException {
		
			ObjectMapper mapper = new ObjectMapper();
			ModelEvent modelEvent = mapper.readValue(data, ModelEvent.class);
			Document document = new Document();
			document.setContent(file.getBytes());
			document.setContentType(file.getContentType());
			document.setCreated(new Date());
			document.setFilename(file.getOriginalFilename());
			modelEvent.setIdCard(document);
			return eventService.addEvent(modelEvent);
			
	} 
	
	@CrossOrigin
	@GetMapping("/events/{id}")
	public ModelEvent getEvents(@PathVariable ("id") Integer id) throws ServiceException {
		return eventService.fetchEventById(id);
	}
	
	@CrossOrigin
	@GetMapping("/events")
	public List<ModelEvent> getAllEvents() throws ServiceException {
		return eventService.fetchAllEvents();
	}
	
	@CrossOrigin
	@RequestMapping("/idcard/{id}")
	public String download(@PathVariable("id")
			Integer id, HttpServletResponse response) throws ServiceException {
		Document doc = documentService.fetchDocumentById(id);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFilename()+ "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(doc.getContentType());
			out.write(doc.getContent());
			out.flush();
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	@CrossOrigin
	@DeleteMapping("/events/{id}")
	public void deleteEvent(@PathVariable ("id") Integer id) throws ServiceException {
		eventService.deleteEventById(id);
	}
}
