package com.codeup.studentdashboard.dao.repository;

import com.codeup.studentdashboard.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User getById(Long id);
}
