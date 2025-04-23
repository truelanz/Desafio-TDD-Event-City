package com.devsuperior.bds02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.bds02.repositories.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    
}
