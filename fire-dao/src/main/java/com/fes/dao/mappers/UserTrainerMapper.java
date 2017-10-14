package com.fes.dao.mappers;

import com.fes.dao.domain.UserTrainer;
import org.apache.ibatis.annotations.Param;

/**
 * Created by qigege on 2017/9/3.
 */
public interface UserTrainerMapper {
    UserTrainer getTrainer(@Param("username") String username);

    UserTrainer getTrainerById(@Param("id") int id);

    boolean updatePicUrl(@Param("url") String url, @Param("id") int id);
}
