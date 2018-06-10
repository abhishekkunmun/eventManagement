package com.abhi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.app.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer>{

}
