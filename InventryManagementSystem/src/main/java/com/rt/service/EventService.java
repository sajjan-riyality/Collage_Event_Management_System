package com.rt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.entity.Event;
import com.rt.entity.EventRegistration;
import com.rt.repository.EventRegistrationRepository;
import com.rt.repository.EventRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll(); 
    }


    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

	public Event updateEvent(Long id, Event updatedEvent) {
		 Event existingEvent = eventRepository.findById(id)
			        .orElseThrow(() -> new RuntimeException("Event not found"));

			    existingEvent.setTitle(updatedEvent.getTitle());
			    existingEvent.setDescription(updatedEvent.getDescription());
			    existingEvent.setDate(updatedEvent.getDate());
			    existingEvent.setLocation(updatedEvent.getLocation());

			    return eventRepository.save(existingEvent);
			}

	
	
	
	
	
	

	    @Autowired
	    private EventRegistrationRepository registrationRepository;

	    public List<EventRegistration> getAllRegistrations() {
	        return registrationRepository.findAll();
	    }


	
	
	
	
	
	
	
	
	
	
	
	public List<Event> getAvailableEventsForStudent(Long studentId) {
	    List<Event> allEvents = eventRepository.findAll();
	    List<Event> registeredEvents = eventRepository.findEventsByRegisteredStudentId(studentId);

	    // Filter out registered events
	    return allEvents.stream()
	            .filter(event -> !registeredEvents.contains(event))
	            .collect(Collectors.toList());
	}

	
	

	
}

