package com.rt.repository;

import com.rt.entity.EventImage;
import com.rt.entity.Event;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventImageRepository extends JpaRepository<EventImage, Long> {
    EventImage findByEvent(Event event);

    Optional<EventImage> findByEventId(Long eventId);
}
