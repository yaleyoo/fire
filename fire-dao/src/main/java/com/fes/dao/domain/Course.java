package com.fes.dao.domain;

/**
 * Created by qigege on 2017/9/3.
 */
public class Course {

    private int id;
    private String courseName;
    private String courseDesc;
    private String duration;
    private int courseType;
    private int coursePrice;
    private String courseIcon;
    private String courseDescBrief;

    public String getCourseDescBrief() {
        return courseDescBrief;
    }

    public void setCourseDescBrief(String courseDescBrief) {
        this.courseDescBrief = courseDescBrief;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCourseIcon() {
        return courseIcon;
    }

    public void setCourseIcon(String courseIcon) {
        this.courseIcon = courseIcon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public int getCourseType() {
        return courseType;
    }

    public void setCourseType(int courseType) {
        this.courseType = courseType;
    }

    public int getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(int coursePrice) {
        this.coursePrice = coursePrice;
    }
}
