package com.codeup.studentdashboard.dao.repository;

import com.codeup.studentdashboard.models.Events;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Events, Long> {

}
