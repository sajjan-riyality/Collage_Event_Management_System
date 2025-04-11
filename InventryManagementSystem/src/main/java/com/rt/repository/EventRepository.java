package com.rt.repository;

import com.rt.entity.Event;
import com.rt.entity.EventImage;
import com.rt.entity.EventRegistration;
import com.rt.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    // You can add custom query methods here if needed
    // Example:
    // List<Event> findByTitleContaining(String keyword);
	
//	Optional<EventImage> findByEventId(Long eventId);
	
	 Optional<Event> findById(Long id); 
	 
	 @Query("SELECT e FROM Event e LEFT JOIN FETCH e.eventImage")
	 List<Event> findAllWithImages();

	 @Query("SELECT r.event FROM Registration r WHERE r.user.id = :studentId")
	 List<Event> findEventsByRegisteredStudentId(@Param("studentId") Long studentId);

//	 boolean existsByUserAndEvent(User user, Event event);
//	    List<EventRegistration> findByUser(User user);
	    
	    List<Event> findByUser(User user);


	    



}
