package com.rt.service;

import com.rt.entity.Event;
import com.rt.entity.EventRegistration;
import com.rt.entity.Registration;
import com.rt.entity.RegistrationDTO;
import com.rt.entity.User;
import com.rt.repository.EventRegistrationRepository;
import com.rt.repository.EventRepository;
import com.rt.repository.RegistrationRepository;
import com.rt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpSession;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private EventRegistrationRepository eventRegistrationRepository ;

    public Registration registerUserToEvent(Long userId, Long eventId) {
        User user = userRepository.findById(userId).orElse(null);
        Event event = eventRepository.findById(eventId).orElse(null);

        if (user == null || event == null) return null;

        Registration registration = new Registration();
        registration.setUser(user);
        registration.setEvent(event);
        registration.setRegistrationTime(LocalDateTime.now());
        registration.setCertificateGenerated(false);

        return registrationRepository.save(registration);
    }
    
   
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }
    

public List<RegistrationDTO> getStudentsByEventId(Long eventId) {
    List<EventRegistration> registrations = null;
	try {
		registrations = eventRegistrationRepository.findByEventId(eventId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    List<RegistrationDTO> dtoList = registrations.stream().map(reg -> {
        RegistrationDTO dto = new RegistrationDTO();
        dto.setId(reg.getId());
        dto.setUsername(reg.getUser() != null ? reg.getUser().getUsername() : "N/A");
        dto.setEmail(reg.getUser() != null ? reg.getUser().getEmail() : "N/A");
        dto.setEventTitle(reg.getEvent() != null ? reg.getEvent().getTitle() : "N/A");
        dto.setRegistrationTime(reg.getRegistrationTime());

        // Console log to verify
        System.out.println("ID: " + dto.getId()
                + ", Username: " + dto.getUsername()
                + ", Email: " + dto.getEmail()
                + ", Event: " + dto.getEventTitle()
                + ", Time: " + dto.getRegistrationTime());

        return dto;
    }).collect(Collectors.toList());

    return dtoList;
}




public List<RegistrationDTO> getRegistrationsByUserId(Long userId) {
    List<EventRegistration> registrations = null;
    try {
        registrations = eventRegistrationRepository.findByUserId(userId);
    } catch (Exception e) {
        e.printStackTrace(); // Optional: log properly in production
    }

    List<RegistrationDTO> dtoList = registrations.stream().map(reg -> {
        RegistrationDTO dto = new RegistrationDTO();
        dto.setId(reg.getId());
        dto.setUsername(reg.getUser() != null ? reg.getUser().getUsername() : "N/A");
        dto.setEmail(reg.getUser() != null ? reg.getUser().getEmail() : "N/A");
        dto.setEventTitle(reg.getEvent() != null ? reg.getEvent().getTitle() : "N/A");
        dto.setRegistrationTime(reg.getRegistrationTime());

        // Console log to verify
        System.out.println("ID: " + dto.getId()
                + ", Username: " + dto.getUsername()
                + ", Email: " + dto.getEmail()
                + ", Event: " + dto.getEventTitle()
                + ", Time: " + dto.getRegistrationTime());

        return dto;
    }).collect(Collectors.toList());

    return dtoList;
}



    
    

  
    public Registration getRegistrationById(Long id) {
        return registrationRepository.findById(id).orElse(null);
    }

    public List<User> getUsersByEventId(Long eventId) {
        List<Registration> registrations = registrationRepository.findByEventId(eventId);
        return registrations.stream()
                .map(Registration::getUser)
                .collect(Collectors.toList());
    }

    public List<Event> getEventsByUserId(Long userId) {
        List<Registration> registrations = registrationRepository.findAllByUserId(userId);
        return registrations.stream()
                .map(Registration::getEvent)
                .collect(Collectors.toList());
    }
    
 
    public boolean deleteRegistration(Long registrationId) {
        if (registrationRepository.existsById(registrationId)) {
            registrationRepository.deleteById(registrationId);
            return true;
        }
        return false;
    }
    

    @Autowired
    private RegistrationRepository registrationRepo;


	public void generateCertificates() {
		// TODO Auto-generated method stub
		
	}



//	public List<RegistrationDTO> saveRegistration(String name, String email, String phone, String comments,
//            Long eventId, String userEmailOrUsername) {
//
//Event event = eventRepository.findById(eventId)
//.orElseThrow(() -> new RuntimeException("Event not found"));
//
//User user = userRepository.findByEmail(userEmailOrUsername)
//.orElseThrow(() -> new RuntimeException("User not found"));
//
//EventRegistration registration = new EventRegistration();
//registration.setName(name);
//registration.setEmail(email);
//registration.setPhone(phone);
//registration.setComments(comments);
//registration.setUser(user);
//registration.setEvent(event);
//registration.setRegistrationTime(LocalDateTime.now());
//
//eventRegistrationRepository.save(registration);
//return null;
//	
//	
//	
//	}

	
	

    



//    public List<Registration> getRegistrationsByUserId(Long userId) {
//        return registrationRepository.findAllByUserId(userId);
//    }


	public List<RegistrationDTO> getRegistrationsByUser() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<RegistrationDTO> saveRegistration(String name, String email, String phone, String comments,
			Long eventId, String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	/*
	 * public List<RegistrationDTO> saveRegistration(String name, String email,
	 * String phone, String comments, Long eventId, String userEmail) { // Fetch
	 * Event Optional<Event> optionalEvent = eventRepository.findById(eventId); if
	 * (!optionalEvent.isPresent()) { throw new
	 * RuntimeException("Event not found with ID: " + eventId); }
	 * 
	 * // Fetch User User user = userRepository.findByEmail(userEmail); if (user ==
	 * null) { throw new RuntimeException("User not found with email: " +
	 * userEmail); }
	 * 
	 * // Create EventRegistration entity EventRegistration registration = new
	 * EventRegistration(); registration.setName(name);
	 * registration.setEmail(email); registration.setPhone(phone);
	 * registration.setComments(comments);
	 * registration.setEvent(optionalEvent.get()); registration.setUser(user);
	 * registration.setRegistrationTime(LocalDateTime.now()); // set current
	 * timestamp
	 * 
	 * // Save to DB registrationRepository.save(registration);
	 * 
	 * // Fetch all registrations for this user and map to DTOs
	 * List<EventRegistration> registrations =
	 * registrationRepository.findByUserEmail(userEmail);
	 * 
	 * return registrations.stream() .map(reg -> new RegistrationDTO( reg.getId(),
	 * reg.getName(), reg.getEmail(), reg.getPhone(), reg.getComments(),
	 * reg.getEvent().getTitle(), reg.getUser().getEmail()))
	 * .collect(Collectors.toList()); }
	 */


//
//	public List<RegistrationDTO> saveRegistration(String name, String email, String phone, String comments,
//			Long eventId, String userEmail) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//    
    
}










