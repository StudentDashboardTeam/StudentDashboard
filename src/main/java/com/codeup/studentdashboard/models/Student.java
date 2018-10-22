package com.codeup.studentdashboard.models;

import com.codeup.studentdashboard.models.enums.*;
import com.codeup.studentdashboard.models.student.HearAboutUs;
import com.codeup.studentdashboard.models.student.PaymentOptions;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_cohort",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "cohort_id")
    )
    private Cohort cohort;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "events",
            joinColumns = @JoinColumn(name = "student")
    )
    @org.hibernate.annotations.ForeignKey(name = "none")
    private List<Events> events;

    public Student() {}

    public Student(Student other) {
        this.id = other.id;
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.email = other.email;
        this.phone = other.phone;
        this.allowSms = other.allowSms;
        this.streetAddress = other.streetAddress;
        this.cityOfResidence = other.cityOfResidence;
        this.zipCode = other.zipCode;
        this.age = other.age;
        this.referrer = other.referrer;
        this.gender = other.gender;
        this.freeSchedule = other.freeSchedule;
        this.resumeFile = other.resumeFile;
        this.giBill = other.giBill;
        this.billboards = other.billboards;
        this.describe = other.describe;
        this.descOther = other.descOther;
        this.why = other.why;
        this.questions = other.questions;
        this.paymentOptions = other.paymentOptions;
        this.hearAboutUs = other.hearAboutUs;
        this.cohort = other.cohort;
        this.events = other.events;
    }

    public Student(String firstName, String lastName, String email,
                   String phone, boolean allowSms, String streetAddress,
                   String cityOfResidence, String zipCode, byte age,
                   String referrer, StudentGender gender,
                   boolean freeSchedule, String resumeFile, boolean giBill,
                   StudentBillboards billboards, StudentDescribe describe,
                   String descOther, String why, String questions,
                   PaymentOptions paymentOptions, HearAboutUs hearAboutUs,
                   Cohort cohort, List<Events> events) {
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
        this.events = events;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAllowSms() {
        return allowSms;
    }

    public void setAllowSms(boolean allowSms) {
        this.allowSms = allowSms;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
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

    public String getResumeFile() {
        return resumeFile;
    }

    public void setResumeFile(String resumeFile) {
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

    public String getDescOther() {
        return descOther;
    }

    public void setDescOther(String descOther) {
        this.descOther = descOther;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public PaymentOptions getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(PaymentOptions paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public HearAboutUs getHearAboutUs() {
        return hearAboutUs;
    }

    public void setHearAboutUs(HearAboutUs hearAboutUs) {
        this.hearAboutUs = hearAboutUs;
    }

    public Cohort getCohort() {
        return cohort;
    }

    public void setCohort(Cohort cohort) {
        this.cohort = cohort;
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }
}
