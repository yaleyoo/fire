package com.fes.dao.domain;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by qigege on 2017/9/3.
 */
public class UserOrganization {

    private int id;
    private String classIdList;
    private String userIdList;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String organizationName;
    @NotEmpty
    private String address;
    private String desc;
    private int peopleNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassIdList() {
        return classIdList;
    }

    public void setClassIdList(String classIdList) {
        this.classIdList = classIdList;
    }

    public String getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(String userIdList) {
        this.userIdList = userIdList;
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

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }
}
