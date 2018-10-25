package com.codeup.studentdashboard.dao.repository;

import com.codeup.studentdashboard.models.Events;
import com.codeup.studentdashboard.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Events, Long> {

    Events findFirstByStudentOrderByDateDesc(Student student);
}
