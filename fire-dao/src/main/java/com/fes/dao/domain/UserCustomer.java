package com.fes.dao.domain;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by qigege on 2017/9/3.
 */
public class UserCustomer {

    private int id;
    private String classIdList;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    private int sex;
    private String address;
    private String phoneNum;
    private String desc;
    private String userMailCode;
    private int organizationId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserMailCode() {
        return userMailCode;
    }

    public void setUserMailCode(String userMailCode) {
        this.userMailCode = userMailCode;
    }

    public String getClassIdList() {
        return classIdList;
    }

    public void setClassIdList(String classIdList) {
        this.classIdList = classIdList;
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

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }
}
