package com.codeup.studentdashboard.models;

import com.codeup.studentdashboard.models.enums.*;

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

    @OneToOne
    @Column(name = "payment_options", nullable = false)
    private PaymentOptions paymentOptions;

    //hear about us

    //payments options

    //cohort id
}
