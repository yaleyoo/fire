package com.fes.common.constants;

/**
 * Created by qigege on 2017/9/12.
 */
public enum UserType {
    CUSTOMER(1,"customer"),
    ORGANIZATION(2, "organization"),
    TRAINER(3, "trainer"),
    STAFF(4, "staff"),
    ALL(5, "all");

    public final int userType;

    public final String strUserType;

    UserType(int userType, String strUserType){
        this.userType = userType;
        this.strUserType = strUserType;
    }

    public int getUserType() {
        return userType;
    }
}
