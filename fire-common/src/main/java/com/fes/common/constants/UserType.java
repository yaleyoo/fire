package com.fes.common.constants;

/**
 * Created by qigege on 2017/9/12.
 */
public enum UserType {
    CUSTOMER(1),
    ORGANIZATION(2),
    TRAINER(3),
    STAFF(4),
    ALL(5);

    public final int userType;

    UserType(int userType){
        this.userType = userType;
    }

    public int getUserType() {
        return userType;
    }
}
