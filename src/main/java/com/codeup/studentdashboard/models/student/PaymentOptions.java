package com.codeup.studentdashboard.models.student;

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

    public PaymentOptions(PaymentOptions copy) {
        id = copy.id;
        self = copy.self;
        va = copy.va;
        loan = copy.loan;
        scholarship = copy.scholarship;
        other = copy.other;
    }

    public PaymentOptions(boolean self, boolean va, boolean loan,
                          boolean scholarship, boolean other) {
        this.self = self;
        this.va = va;
        this.loan = loan;
        this.scholarship = scholarship;
        this.other = other;
    }

    public long id() {
        return id;
    }

    public void id(long id) {
        this.id = id;
    }

    public boolean isself() {
        return self;
    }

    public void self(boolean self) {
        this.self = self;
    }

    public boolean isva() {
        return va;
    }

    public void va(boolean va) {
        this.va = va;
    }

    public boolean isloan() {
        return loan;
    }

    public void loan(boolean loan) {
        this.loan = loan;
    }

    public boolean isscholarship() {
        return scholarship;
    }

    public void scholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }

    public boolean isother() {
        return other;
    }

    public void other(boolean other) {
        this.other = other;
    }
}
