package com.rt.repository;

import javax.persistence.*;

import com.rt.entity.Event;
import com.rt.entity.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "event_registration")
public class RegistrationDetailsDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "student_email")
    private String email;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @Lob
    private String comments;

    @Column(name = "registration_time")
    private LocalDateTime registrationTime;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // Constructors
    public RegistrationDetailsDTO() {}

    public RegistrationDetailsDTO(String name, String email, String phone, Event event,
                        String comments, LocalDateTime registrationTime, User user) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.event = event;
        this.comments = comments;
        this.registrationTime = registrationTime;
        this.user = user;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
