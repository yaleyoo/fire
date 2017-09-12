package com.fes.dao.mappers;

import com.fes.dao.domain.UserStaff;
import org.apache.ibatis.annotations.Param;

/**
 * Created by qigege on 2017/9/3.
 */
public interface UserStaffMapper {
    UserStaff getStaff(@Param("username") String username);
}
