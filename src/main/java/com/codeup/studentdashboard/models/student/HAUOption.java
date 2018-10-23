package com.codeup.studentdashboard.models.student;

import javax.persistence.*;

@Entity
@Table(name = "hau_options")
public class HAUOption {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    public HAUOption() {
    }

    public HAUOption(HAUOption copy) {
        this.id = copy.id;
        this.name = copy.name;
    }

    public HAUOption(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
