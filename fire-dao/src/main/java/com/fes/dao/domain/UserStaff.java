package com.fes.dao.domain;

/**
 * Created by qigege on 2017/9/3.
 */
public class UserStaff {

    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int sex;
    private String address;
    private String phoneNum;
    private String desc;
    private int generalUserManage;
    private int trainerUserManage;
    private int courseManage;
    private int priceManage;
    private int staffUserManage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getGeneralUserManage() {
        return generalUserManage;
    }

    public void setGeneralUserManage(int generalUserManage) {
        this.generalUserManage = generalUserManage;
    }

    public int getTrainerUserManage() {
        return trainerUserManage;
    }

    public void setTrainerUserManage(int trainerUserManage) {
        this.trainerUserManage = trainerUserManage;
    }

    public int getCourseManage() {
        return courseManage;
    }

    public void setCourseManage(int courseManage) {
        this.courseManage = courseManage;
    }

    public int getPriceManage() {
        return priceManage;
    }

    public void setPriceManage(int priceManage) {
        this.priceManage = priceManage;
    }

    public int getStaffUserManage() {
        return staffUserManage;
    }

    public void setStaffUserManage(int staffUserManage) {
        this.staffUserManage = staffUserManage;
    }
}
