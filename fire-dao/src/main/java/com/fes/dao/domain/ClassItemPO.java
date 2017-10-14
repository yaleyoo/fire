package com.fes.dao.domain;

import java.sql.Date;

/**
 * Created by qigege on 2017/9/3.
 */
public class ClassItemPO {

    private int id;
    private int classId;
    private Date classDate;
    private int equipConsumption;
    private int attendantStudentsNum;
    private String attendantStudents;
    private String startTime;
    private String endTime;
    private String strDate;

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Date getClassDate() {
        return classDate;
    }

    public void setClassDate(Date classDate) {
        this.classDate = classDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getEquipConsumption() {
        return equipConsumption;
    }

    public void setEquipConsumption(int equipConsumption) {
        this.equipConsumption = equipConsumption;
    }

    public int getAttendantStudentsNum() {
        return attendantStudentsNum;
    }

    public void setAttendantStudentsNum(int attendantStudentsNum) {
        this.attendantStudentsNum = attendantStudentsNum;
    }

    public String getAttendantStudents() {
        return attendantStudents;
    }

    public void setAttendantStudents(String attendantStudents) {
        this.attendantStudents = attendantStudents;
    }
}
