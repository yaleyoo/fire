package com.fes.dao.mappers;

import com.fes.dao.domain.UserCustomer;
import com.fes.dao.domain.UserOrganization;
import com.fes.dao.domain.UserStaff;
import com.fes.dao.domain.UserTrainer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qigege on 2017/9/3.
 */
public interface UserCustomerMapper {

    List<UserCustomer> getAllCustomerInfo();

    UserCustomer getCustomer(@Param("username") String username);






}
