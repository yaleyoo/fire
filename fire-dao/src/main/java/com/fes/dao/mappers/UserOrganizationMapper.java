package com.fes.dao.mappers;

import com.fes.dao.domain.UserOrganization;
import org.apache.ibatis.annotations.Param;

/**
 * Created by qigege on 2017/9/3.
 */
public interface UserOrganizationMapper {
    UserOrganization getOrganization(@Param("username") String username);
}
