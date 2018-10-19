package com.codeup.studentdashboard.models;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue
    private long id;

    @Column(nullable=false, length = 45)
    private String username;

    @Column(nullable = false, length = 45)
    private String email;

    @Column(nullable = false, length = 98)
    private String password;
}
