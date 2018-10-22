package com.codeup.studentdashboard.models;
import com.codeup.studentdashboard.models.enums.CohortType;
import com.codeup.studentdashboard.models.enums.CohortTypeConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @JoinTable(
            name = "student",
            joinColumns = @JoinColumn(name = "id")
    )
    private List<Student> students;

    public Cohort() {}

    public Cohort(Cohort copy) {
        id = copy.id;
        name = copy.name;
        startDate = copy.startDate;
        endDate = copy.endDate;
        type = copy.type;
        students = copy.students;
    }

    public Cohort(String name, Date startDate, Date endDate, CohortType type, List<Student> students) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
