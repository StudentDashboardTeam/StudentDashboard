package com.codeup.studentdashboard.models;

import javax.persistence.*;
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
    private Date date;

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

    public Events(Event type, User user, Student student, Date date,
                  String notes, int score) {
        this.type = type;
        this.user = user;
        this.student = student;
        this.date = date;
        this.notes = notes;
        this.score = score;
    }

    public long id() {
        return id;
    }

    public void id(long id) {
        this.id = id;
    }

    public Event type() {
        return type;
    }

    public void type(Event type) {
        this.type = type;
    }

    public User user() {
        return user;
    }

    public void user(User user) {
        this.user = user;
    }

    public Student student() {
        return student;
    }

    public void student(Student student) {
        this.student = student;
    }

    public Date date() {
        return date;
    }

    public void date(Date date) {
        this.date = date;
    }

    public String notes() {
        return notes;
    }

    public void notes(String notes) {
        this.notes = notes;
    }

    public int score() {
        return score;
    }

    public void score(int score) {
        this.score = score;
    }
}
