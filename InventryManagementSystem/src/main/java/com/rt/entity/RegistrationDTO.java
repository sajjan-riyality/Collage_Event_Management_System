package com.rt.entity;

import java.time.LocalDateTime;

public class RegistrationDTO {

    private Long id;
    private String username;
    private String email;
    private String eventTitle;
    private LocalDateTime registrationTime;

    public RegistrationDTO() {
    }

    public RegistrationDTO(Long id, String username, String email, String phone, LocalDateTime registrationTime, String eventTitle) {
        this.id = id;
        this.username = username;
        this.email = email;
       
        this.eventTitle = eventTitle;
        this.registrationTime = registrationTime;
    }

    public RegistrationDTO(Long id2, String username2, String email2, String title, LocalDateTime registrationTime2) {
    	 this.id = id2;
         this.username = username2;
         this.email = email2;
        
         this.eventTitle = title;
         this.registrationTime = registrationTime2;
	}

	

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }
}
