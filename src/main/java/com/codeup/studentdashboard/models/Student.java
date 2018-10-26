package com.codeup.studentdashboard.models;

import com.codeup.studentdashboard.models.enums.*;
import com.codeup.studentdashboard.models.enums.StudentGender;
import com.codeup.studentdashboard.models.student.HAUOption;
import com.codeup.studentdashboard.models.student.PaymentOption;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "first_name", nullable = false)
    private java.lang.String firstName;

    @Column(name = "last_name", nullable = false)
    private java.lang.String lastName;

    @Column(name = "email", nullable = false)
    private java.lang.String email;

    @Column(name = "phone", nullable = false)
    private java.lang.String phone;

    @Column(name = "allow_sms", nullable = false)
    private boolean allowSms;

    @Column(name = "street_address", nullable = false)
    private java.lang.String streetAddress;

    @Column(name = "city_of_residence", nullable = false)
    private java.lang.String cityOfResidence;

    @Column(name = "zip_code", nullable = false)
    private java.lang.String zipCode;

    @Column(name = "age", nullable = false)
    private byte age;

    @Column(name = "referrer")
    private java.lang.String referrer;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "gender")
    private StudentGender gender;

    @Column(name = "free_schedule", nullable = false)
    private boolean freeSchedule;

    @Column(name = "resume_file")
    private java.lang.String resumeFile;

    @Column(name = "gi_bill", nullable = false)
    private boolean giBill;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "billboards", nullable = false)
    private StudentBillboards billboards;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "best_describes_you")
    private StudentDescribe describe;

    @Column(name = "description_other", columnDefinition = "TEXT")
    private java.lang.String descOther;

    @Column(name = "why", nullable = false, columnDefinition = "TEXT")
    private java.lang.String why;

    @Column(name = "questions", columnDefinition = "TEXT")
    private java.lang.String questions;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "payment_options_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "payment_options_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"payment_options_id", "student_id"})
    )
    private List<PaymentOption> paymentOptions;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "hau_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "hau_options_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"hau_options_id", "student_id"})
    )
    private List<HAUOption> hauOptions;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_cohort",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "cohort_id")
    )
    private Cohort cohort;

    @OneToMany(fetch =  FetchType.LAZY, mappedBy = "student")
    private List<Events> events;

    public Student() {}

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
        this.hauOptions = copy.hauOptions;
        this.cohort = copy.cohort;
        this.events = copy.events;
    }

    public Student(java.lang.String firstName, java.lang.String lastName, java.lang.String email,
                   java.lang.String phone, boolean allowSms, java.lang.String streetAddress,
                   java.lang.String cityOfResidence, java.lang.String zipCode, byte age,
                   java.lang.String referrer, StudentGender gender,
                   boolean freeSchedule, java.lang.String resumeFile, boolean giBill,
                   StudentBillboards billboards, StudentDescribe describe,
                   java.lang.String descOther, java.lang.String why, java.lang.String questions,
                   List<PaymentOption> paymentOptions,
                   List<HAUOption> hauOptions, Cohort cohort,
                   List<Events> events) {
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
        this.hauOptions = hauOptions;
        this.cohort = cohort;
        this.events = events;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getPhone() {
        return phone;
    }

    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }

    public boolean isAllowSms() {
        return allowSms;
    }

    public void setAllowSms(boolean allowSms) {
        this.allowSms = allowSms;
    }

    public java.lang.String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(java.lang.String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public java.lang.String getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(java.lang.String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public java.lang.String getZipCode() {
        return zipCode;
    }

    public void setZipCode(java.lang.String zipCode) {
        this.zipCode = zipCode;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public java.lang.String getReferrer() {
        return referrer;
    }

    public void setReferrer(java.lang.String referrer) {
        this.referrer = referrer;
    }

    public StudentGender getGender() {
        return gender;
    }

    public void setGender(StudentGender gender) {
        this.gender = gender;
    }

    public boolean isFreeSchedule() {
        return freeSchedule;
    }

    public void setFreeSchedule(boolean freeSchedule) {
        this.freeSchedule = freeSchedule;
    }

    public java.lang.String getResumeFile() {
        return resumeFile;
    }

    public void setResumeFile(java.lang.String resumeFile) {
        this.resumeFile = resumeFile;
    }

    public boolean isGiBill() {
        return giBill;
    }

    public void setGiBill(boolean giBill) {
        this.giBill = giBill;
    }

    public StudentBillboards getBillboards() {
        return billboards;
    }

    public void setBillboards(StudentBillboards billboards) {
        this.billboards = billboards;
    }

    public StudentDescribe getDescribe() {
        return describe;
    }

    public void setDescribe(StudentDescribe describe) {
        this.describe = describe;
    }

    public java.lang.String getDescOther() {
        return descOther;
    }

    public void setDescOther(java.lang.String descOther) {
        this.descOther = descOther;
    }

    public java.lang.String getWhy() {
        return why;
    }

    public void setWhy(java.lang.String why) {
        this.why = why;
    }

    public java.lang.String getQuestions() {
        return questions;
    }

    public void setQuestions(java.lang.String questions) {
        this.questions = questions;
    }

    public List<PaymentOption> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(List<PaymentOption> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public List<HAUOption> getHauOptions() {
        return hauOptions;
    }

    public void setHauOptions(List<HAUOption> hauOptions) {
        this.hauOptions = hauOptions;
    }

    public Cohort getCohort() {
        return cohort;
    }

    public void setCohort(Cohort cohort) {
        this.cohort = cohort;
    }

    public List<Events> getEvents() {
        events.sort(Comparator.comparing(Events::getDate).reversed());
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }
}
