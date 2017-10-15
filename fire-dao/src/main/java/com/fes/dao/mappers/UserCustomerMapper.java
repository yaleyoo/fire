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

    UserCustomer selectByName(@Param("username") String username);

    boolean insertCustomer(UserCustomer user);

    UserCustomer selectById(@Param("id") int userId);

    boolean update(UserCustomer user);

    boolean deleteCustomer(@Param("id")int id);

    List<UserCustomer> selectByIds(@Param("ids") List<String> ids);

}
