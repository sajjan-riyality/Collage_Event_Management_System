package com.rt.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many registrations can belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_event_user"))
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(name = "registration_time")
    private LocalDateTime registrationTime;


    @Column(name = "certificate_generated", nullable = false)
    private boolean certificateGenerated = false;
    
    
   
    

    // Constructors
    public Registration() {}

    public Registration(Long id, User user, Event event, LocalDateTime registrationTime, boolean certificateGenerated) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.registrationTime = registrationTime;
        this.certificateGenerated = certificateGenerated;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public boolean isCertificateGenerated() {
        return certificateGenerated;
    }

    public void setCertificateGenerated(boolean certificateGenerated) {
        this.certificateGenerated = certificateGenerated;
    }

	
	
}
