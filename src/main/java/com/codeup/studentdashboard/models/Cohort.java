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

    public Cohort() {}

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CohortType getType() {
        return type;
    }

    public void setType(CohortType type) {
        this.type = type;
    }
}
