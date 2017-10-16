package com.fes.dao.domain;

import java.sql.Date;

/**
 * Created by qigege on 2017/9/3.
 */
public class ClassPO {

    private int id;
    private int courseId;
    private String classItemIds;
    private int tutorId;
    private String tutorName;
    private String courseName;
    private String tutorPic;
    private String tutorDesc;
    private String classAddr;
    private Date classStartTime;
    private String strTime;
    private String classTimeTable;
    private int price;
    private int registeredNum;
    private String registeredStudents;
    private String contactDetail;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTutorPic() {
        return tutorPic;
    }

    public void setTutorPic(String tutorPic) {
        this.tutorPic = tutorPic;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getClassItemIds() {
        return classItemIds;
    }

    public void setClassItemIds(String classItemIds) {
        this.classItemIds = classItemIds;
    }

    public int getTutorId() {
        return tutorId;
    }

    public void setTutorId(int tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getTutorDesc() {
        return tutorDesc;
    }

    public void setTutorDesc(String tutorDesc) {
        this.tutorDesc = tutorDesc;
    }

    public String getClassAddr() {
        return classAddr;
    }

    public void setClassAddr(String classAddr) {
        this.classAddr = classAddr;
    }

    public Date getClassStartTime() {
        return classStartTime;
    }

    public void setClassStartTime(Date classStartTime) {
        this.classStartTime = classStartTime;
    }

    public String getClassTimeTable() {
        return classTimeTable;
    }

    public void setClassTimeTable(String classTimeTable) {
        this.classTimeTable = classTimeTable;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRegisteredNum() {
        return registeredNum;
    }

    public void setRegisteredNum(int registeredNum) {
        this.registeredNum = registeredNum;
    }

    public String getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(String registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public String getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(String contactDetail) {
        this.contactDetail = contactDetail;
    }
}
