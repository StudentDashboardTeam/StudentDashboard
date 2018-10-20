package com.codeup.studentdashboard.models;
import com.codeup.studentdashboard.models.enums.CohortType;
import com.codeup.studentdashboard.models.enums.CohortTypeConverter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cohort")
public class Cohort {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    @Convert(converter = CohortTypeConverter.class)
    private CohortType type;

    public Cohort(Cohort copy) {
        id = copy.id;
        name = copy.name;
        startDate = copy.startDate;
        endDate = copy.endDate;
        type = copy.type;
    }

    public Cohort(String name, Date startDate, Date endDate, CohortType type) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
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

    public Date start_date() {
        return startDate;
    }

    public void start_date(Date startDate) {
        this.startDate = startDate;
    }

    public Date end_date() {
        return endDate;
    }

    public void end_date(Date endDate) {
        this.endDate = endDate;
    }

    public CohortType type() {
        return type;
    }

    public void type(CohortType type) {
        this.type = type;
    }
}
