package com.yswu.ems.dao;

import com.yswu.ems.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author yswu
 * @date 2021-03-23 17:31
 */
public interface UserDao {

    void save(User user);
    User login(@Param("username") String username, @Param("password") String password);

}
