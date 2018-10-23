package com.codeup.studentdashboard.models.student;

import javax.persistence.*;

@Entity
@Table(name = "payment_options")
public class PaymentOption {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    public PaymentOption() {}

    public PaymentOption(PaymentOption copy) {
        this.id = copy.id;
        this.name = copy.name;
    }

    public PaymentOption(String name) {
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
