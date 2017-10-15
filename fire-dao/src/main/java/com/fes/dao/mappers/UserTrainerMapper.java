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

    boolean updateProfile(@Param("id") int id, @Param("username") String username, @Param("password") String password, @Param("firstname") String firstname,
                          @Param("lastname") String lastname, @Param("sex") int sex,@Param("address") String address,
                          @Param("phoneNum") String phoneNum, @Param("desc") String description);

    boolean updateAvailability(@Param("id") int id, @Param("availability") String availability);
}
