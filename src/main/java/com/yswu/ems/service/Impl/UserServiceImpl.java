package com.yswu.ems.service.Impl;

import com.yswu.ems.dao.UserDao;
import com.yswu.ems.entity.User;
import com.yswu.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author yswu
 * @date 2021-03-24 17:25
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;
    @Override
    public void register(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.save(user);
    }
}
