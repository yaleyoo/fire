package com.fes.dao.mappers;

import com.fes.dao.domain.UserCustomer;
import com.fes.dao.domain.UserOrganization;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * Created by qigege on 2017/9/3.
 */
public interface UserOrganizationMapper {

    UserOrganization getOrganization(@Param("username") String username);
    
    UserOrganization showOrganizationByID(@Param("organizationID") int organizationID);
    
    boolean insertCustomer(UserOrganization user);

    String selectMembers(@Param("id") int id);

    UserOrganization selectByName(@Param("username") String username);

    List<UserOrganization> getAllOrgInfo();

    boolean deleteCustomer(@Param("id") int id);

    boolean modifyOrganization(UserOrganization userOrganization);
}
