package com.abhi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.app.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
