package com.codeup.studentdashboard.models.student;

import javax.persistence.*;

@Entity
@Table(name = "hear_about_us")
public class HearAboutUs {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "twitter_facebook")
    private boolean twitterFacebook;

    @Column(name = "youtube")
    private boolean youtube;

    @Column(name = "muse")
    private boolean muse;

    @Column(name = "billboard")
    private boolean billboard;

    @Column(name = "tv")
    private boolean tv;

    @Column(name = "radio")
    private boolean radio;

    @Column(name = "news")
    private boolean news;

    @Column(name = "web")
    private boolean web;

    @Column(name = "geekdom")
    private boolean geekdom;

    @Column(name = "friend_family")
    private boolean friendFamily;

    @Column(name = "employer")
    private boolean employer;

    @Column(name = "student")
    private boolean student;

    @Column(name = "job_school_fair")
    private boolean jobSchoolFair;

    @Column(name = "other")
    private boolean other;

    public HearAboutUs(HearAboutUs copy) {
        id = copy.id;
        twitterFacebook = copy.twitterFacebook;
        youtube = copy.youtube;
        muse = copy.muse;
        billboard = copy.billboard;
        tv = copy.tv;
        radio = copy.radio;
        news = copy.news;
        web = copy.web;
        geekdom = copy.geekdom;
        friendFamily = copy.friendFamily;
        employer = copy.employer;
        student = copy.student;
        jobSchoolFair = copy.jobSchoolFair;
        other = copy.other;
    }

    public HearAboutUs(boolean twitterFacebook, boolean youtube, boolean muse
            , boolean billboard, boolean tv, boolean radio, boolean news,
                       boolean web, boolean geekdom, boolean friendFamily,
                       boolean employer, boolean student,
                       boolean jobSchoolFair, boolean other) {
        this.twitterFacebook = twitterFacebook;
        this.youtube = youtube;
        this.muse = muse;
        this.billboard = billboard;
        this.tv = tv;
        this.radio = radio;
        this.news = news;
        this.web = web;
        this.geekdom = geekdom;
        this.friendFamily = friendFamily;
        this.employer = employer;
        this.student = student;
        this.jobSchoolFair = jobSchoolFair;
        this.other = other;
    }

    public long id() {
        return id;
    }

    public void id(long id) {
        this.id = id;
    }

    public boolean istwitterFacebook() {
        return twitterFacebook;
    }

    public void twitterFacebook(boolean twitterFacebook) {
        this.twitterFacebook = twitterFacebook;
    }

    public boolean isyoutube() {
        return youtube;
    }

    public void youtube(boolean youtube) {
        this.youtube = youtube;
    }

    public boolean ismuse() {
        return muse;
    }

    public void muse(boolean muse) {
        this.muse = muse;
    }

    public boolean isbillboard() {
        return billboard;
    }

    public void billboard(boolean billboard) {
        this.billboard = billboard;
    }

    public boolean istv() {
        return tv;
    }

    public void tv(boolean tv) {
        this.tv = tv;
    }

    public boolean isradio() {
        return radio;
    }

    public void radio(boolean radio) {
        this.radio = radio;
    }

    public boolean isnews() {
        return news;
    }

    public void news(boolean news) {
        this.news = news;
    }

    public boolean isweb() {
        return web;
    }

    public void web(boolean web) {
        this.web = web;
    }

    public boolean isgeekdom() {
        return geekdom;
    }

    public void geekdom(boolean geekdom) {
        this.geekdom = geekdom;
    }

    public boolean isfriendFamily() {
        return friendFamily;
    }

    public void friendFamily(boolean friendFamily) {
        this.friendFamily = friendFamily;
    }

    public boolean isemployer() {
        return employer;
    }

    public void employer(boolean employer) {
        this.employer = employer;
    }

    public boolean isstudent() {
        return student;
    }

    public void student(boolean student) {
        this.student = student;
    }

    public boolean isjobSchoolFair() {
        return jobSchoolFair;
    }

    public void jobSchoolFair(boolean jobSchoolFair) {
        this.jobSchoolFair = jobSchoolFair;
    }

    public boolean isother() {
        return other;
    }

    public void other(boolean other) {
        this.other = other;
    }
}
