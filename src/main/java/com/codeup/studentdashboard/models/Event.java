package com.codeup.studentdashboard.models;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Event(Event copy) {
        this.id = copy.id;
        this.name = copy.name;
    }

    public Event(String name) {
        this.name = name;
    }

    public long id() {
        return id;
    }

    public void id(long id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }
}
