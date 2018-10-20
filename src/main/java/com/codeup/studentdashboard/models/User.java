package com.codeup.studentdashboard.models;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(nullable=false, length = 45)
    private String username;

    @Column(nullable = false, length = 45)
    private String email;

    @Column(nullable = false, length = 98)
    private String password;

    public User() {
    }

    public User(User copy){
        id = copy.id;
        username = copy.username;
        email = copy.email;
        password = copy.password;
    }

    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long id() {
        return id;
    }

    public void id(long id) {
        this.id = id;
    }

    public String username() {
        return this.username;
    }

    public void username(String username) {
        this.username = username;
    }

    public String email() {
        return email;
    }

    public void email(String email) {
        this.email = email;
    }

    public String password() {
        return password;
    }

    public void password(String password) {
        this.password = password;
    }

    public String getUsername() { return this.username; }

    public void setUsername(String username) { this.username = username; }

    public void setEmail(String email) { this.email = email; }

    public String getEmail() { return this.email; }

    public String getPassword() { return this.password; }

    public void setPassword(String password) { this.password = password; }

//    public User findByUsername(String username) {
//
//    };
}
