package com.codeup.studentdashboard.dao.repository;

import com.codeup.studentdashboard.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("from Student s where s.id=?1")
    Student findById(Long id);

}