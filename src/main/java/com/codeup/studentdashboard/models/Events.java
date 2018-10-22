package com.codeup.studentdashboard.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "events")
public class Events {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "type")
    private Event type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "administerer")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student")
    private Student student;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "notes")
    private String notes;

    @Column(name = "score")
    private int score;

    public Events(Events copy) {
        this.id = copy.id;
        this.type = copy.type;
        this.user = copy.user;
        this.student = copy.student;
        this.date = copy.date;
        this.notes = copy.notes;
        this.score = copy.score;
    }

    public Events(Event type, User user, Student student, LocalDateTime date,
                  String notes, int score) {
        this.type = type;
        this.user = user;
        this.student = student;
        this.date = date;
        this.notes = notes;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Event getType() {
        return type;
    }

    public void setType(Event type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
