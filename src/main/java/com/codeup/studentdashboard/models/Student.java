package com.codeup.studentdashboard.models;

import com.codeup.studentdashboard.models.enums.*;
import com.codeup.studentdashboard.models.student.HearAboutUs;
import com.codeup.studentdashboard.models.student.PaymentOptions;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "allow_sms", nullable = false)
    private boolean allowSms;

    @Column(name = "street_address", nullable = false)
    private String streetAddress;

    @Column(name = "city_of_residence", nullable = false)
    private String cityOfResidence;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(name = "age", nullable = false)
    private byte age;

    @Column(name = "referrer")
    private String referrer;

    @Column(name = "gender")
    @Convert(converter = StudentGenderConverter.class)
    private StudentGender gender;

    @Column(name = "free_schedule", nullable = false)
    private boolean freeSchedule;

    @Column(name = "resume_file")
    private String resumeFile;

    @Column(name = "gi_bill", nullable = false)
    private boolean giBill;

    @Column(name = "billboards", nullable = false)
    @Convert(converter = StudentBillboardsConverter.class)
    private StudentBillboards billboards;

    @Column(name = "best_describes_you")
    @Convert(converter = StudentDescribeConverter.class)
    private StudentDescribe describe;

    @Column(name = "description_other")
    private String descOther;

    @Column(name = "why", nullable = false)
    private String why;

    @Column(name = "questions")
    private String questions;

    @OneToOne(optional = false)
    @JoinColumn(name = "payment_options")
    private PaymentOptions paymentOptions;

    @OneToOne(optional = false)
    @JoinColumn(name = "hear_about_us")
    private HearAboutUs hearAboutUs;

    @OneToOne
    private Cohort cohort;

    public Student(Student copy) {
        this.id = copy.id;
        this.firstName = copy.firstName;
        this.lastName = copy.lastName;
        this.email = copy.email;
        this.phone = copy.phone;
        this.allowSms = copy.allowSms;
        this.streetAddress = copy.streetAddress;
        this.cityOfResidence = copy.cityOfResidence;
        this.zipCode = copy.zipCode;
        this.age = copy.age;
        this.referrer = copy.referrer;
        this.gender = copy.gender;
        this.freeSchedule = copy.freeSchedule;
        this.resumeFile = copy.resumeFile;
        this.giBill = copy.giBill;
        this.billboards = copy.billboards;
        this.describe = copy.describe;
        this.descOther = copy.descOther;
        this.why = copy.why;
        this.questions = copy.questions;
        this.paymentOptions = copy.paymentOptions;
        this.hearAboutUs = copy.hearAboutUs;
        this.cohort = copy.cohort;
    }

    public Student(String firstName, String lastName, String email,
                   String phone, boolean allowSms, String streetAddress,
                   String cityOfResidence, String zipCode, byte age,
                   String referrer, StudentGender gender,
                   boolean freeSchedule, String resumeFile, boolean giBill,
                   StudentBillboards billboards, StudentDescribe describe,
                   String descOther, String why, String questions,
                   PaymentOptions paymentOptions, HearAboutUs hearAboutUs,
                   Cohort cohort) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.allowSms = allowSms;
        this.streetAddress = streetAddress;
        this.cityOfResidence = cityOfResidence;
        this.zipCode = zipCode;
        this.age = age;
        this.referrer = referrer;
        this.gender = gender;
        this.freeSchedule = freeSchedule;
        this.resumeFile = resumeFile;
        this.giBill = giBill;
        this.billboards = billboards;
        this.describe = describe;
        this.descOther = descOther;
        this.why = why;
        this.questions = questions;
        this.paymentOptions = paymentOptions;
        this.hearAboutUs = hearAboutUs;
        this.cohort = cohort;
    }
}
