package com.codeup.studentdashboard.dao.repository;

import com.codeup.studentdashboard.models.Cohort;
import com.codeup.studentdashboard.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortRepository extends CrudRepository<Cohort, Long> {

    @Query("from Cohort c where c.id=?1")
    Cohort findById(Long id);

}