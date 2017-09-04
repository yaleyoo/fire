package com.fes.dao.domain;

import java.sql.Date;

/**
 * Created by qigege on 2017/9/3.
 */
public class ClassItemPO {

    private int id;
    private int classId;
    private Date classTime;
    private int equipConsumption;
    private int attendantStudentsNum;
    private String attendantStudents;

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

    public Date getClassTime() {
        return classTime;
    }

    public void setClassTime(Date classTime) {
        this.classTime = classTime;
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
