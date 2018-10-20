package com.codeup.studentdashboard.models;

import javax.persistence.*;

@Entity
@Table(name= "cohorts")
public class Cohort {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false, length = 45)
    private String name;

    @Column(nullable=false)
    private java.sql.Date startDate;

    @Column(nullable=false)
    private java.sql.Date endDate;

    @Column(nullable=false)
    private String type;

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


    public java.sql.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }


    public java.sql.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.sql.Date endDate) {
        this.endDate = endDate;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
