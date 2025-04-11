package com.rt.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rt.entity.Event;
import com.rt.entity.EventRegistration;
import com.rt.entity.Registration;
import com.rt.entity.RegistrationDTO;
import com.rt.entity.User;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByEventId(Long eventId);
    List<Registration> findByUserId(String userEmail);
    boolean existsByUserIdAndEventId(Long userId, Long eventId);
	EventRegistration save(EventRegistration reg);
	boolean existsByUserAndEvent(User user, Event event);
	List<Registration> findAllByUserId(Long userId);
	List<Registration> findByUserUsername(String username);
	List<EventRegistration> findByUserEmail(String userEmail);
	
	
	
//	 @Query("SELECT new com.rt.repository.RegistrationDetailsDTO(r.id, u.username, u.name, r.email, r.phone, e.title, r.comments, r.registrationTime) " +
//	           "FROM Registration r " +
//	           "JOIN r.user u " +
//	           "JOIN r.event e")
//	    List<RegistrationDetailsDTO> fetchAllRegistrationDetails();
	

//	List<RegistrationDTO> findAllByUserId(Long userId);
	
	
//	 List<RegistrationDTO> findAllByUserId(@Param("userId") Long userId);
	
	
	
//	@Query("SELECT new com.rt.entity.RegistrationDTO(r.id, u.name, u.email, e.title, r.registrationTime) " +
//	           "FROM Registration r " +
//	           "JOIN r.user u " +
//	           "JOIN r.event e")
//	    List<RegistrationDTO> findAllRegistrationDTOs();
//
//	    @Query("SELECT new com.rt.entity.RegistrationDTO(r.id, u.name, u.email, e.title, r.registrationTime) " +
//	           "FROM Registration r " +
//	           "JOIN r.user u " +
//	           "JOIN r.event e " +
//	           "WHERE r.id = :id")
//	    RegistrationDTO findRegistrationDTOById(@Param("id") Long id);
}
