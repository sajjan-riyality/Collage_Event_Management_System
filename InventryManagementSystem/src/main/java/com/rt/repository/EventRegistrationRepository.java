package com.rt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rt.entity.EventRegistration;
import com.rt.entity.RegistrationDTO;
import com.rt.entity.User;

@Repository
public interface EventRegistrationRepository extends JpaRepository<EventRegistration, Long> {

	Optional<User> findByUser(User user);
	
	List<EventRegistration> findByEventId(Long eventId);

	List<EventRegistration> findByUserId(Long userId);
	 	
}
