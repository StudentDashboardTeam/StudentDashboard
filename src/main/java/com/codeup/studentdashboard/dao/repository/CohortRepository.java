package com.codeup.studentdashboard.dao.repository;

import com.codeup.studentdashboard.models.Cohort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortRepository extends CrudRepository<Cohort, Long> {
//    User findByUsername(String username);
}