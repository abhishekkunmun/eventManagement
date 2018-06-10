package com.abhi.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abhi.app.entity.Document;
import com.abhi.app.exception.ServiceException;
import com.abhi.app.repository.DocumentRepository;

@Component
public class DocumentService {

	@Autowired
	DocumentRepository docRepo;
	

	public Document fetchDocumentById(Integer id) throws ServiceException {
		Optional<Document> doc = docRepo.findById(id);
		if(!doc.isPresent())
			throw new ServiceException("No Event with Id "+id+" found");
		return doc.get();
	}
	
	
}
