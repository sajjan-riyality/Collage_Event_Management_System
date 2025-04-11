package com.rt.entity;

import javax.persistence.*;

@Entity
@Table(name = "event_image")
public class EventImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="image_url")
    private String imageUrl;

    @OneToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id", unique = true)
    private Event event;

    public EventImage() {}

    public EventImage(String imageUrl, Event event) {
        this.imageUrl = imageUrl;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
  
}
