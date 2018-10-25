package com.codeup.studentdashboard.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "event")
public class Events {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_type")
    private EventType type;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "date", nullable = false)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date date;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "score")
    private Integer score;

    public Events() {
    }

    public Events(Events copy) {
        this.id = copy.id;
        this.type = copy.type;
        this.user = copy.user;
        this.student = copy.student;
        this.date = copy.date;
        this.notes = copy.notes;
        this.score = copy.score;
    }

    public Events(EventType type, User user, Student student,
                  Date date, String notes, Integer score) {
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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
