package com.codeup.studentdashboard.models;
import com.codeup.studentdashboard.models.enums.CohortType;
import com.codeup.studentdashboard.models.enums.CohortTypeConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cohort")
public class Cohort {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    @Convert(converter = CohortTypeConverter.class)
    private CohortType type;

    @OneToMany
    @JoinTable(
            name = "student_cohort",
            joinColumns = @JoinColumn(name = "cohort_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
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

    public Cohort(String name, LocalDate startDate, LocalDate endDate, CohortType type, List<Student> students) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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
