package com.codeup.studentdashboard.models;

import javax.persistence.*;

@Entity
@Table(name = "payment_options")
public class PaymentOptions {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "self")
    private boolean self;

    @Column(name = "va_benefits")
    private boolean va;

    @Column(name = "loan")
    private boolean loan;

    @Column(name = "scholarship")
    private boolean scholarship;

    @Column(name = "other")
    private boolean other;
}
