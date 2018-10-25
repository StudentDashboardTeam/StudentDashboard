package com.codeup.studentdashboard.dao.repository;

import com.codeup.studentdashboard.models.EventType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EventTypeRepository extends CrudRepository<EventType, Long> {
    @Query("FROM EventType et where et.id=?1")
    EventType findById(Long id);
}
