package com.codeup.studentdashboard.dao.repository;

import com.codeup.studentdashboard.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

//    User findByisAdmin(String username);
}
