package com.yswu.ems.service.Impl;

import com.yswu.ems.dao.EmpDao;
import com.yswu.ems.entity.Employees;
import com.yswu.ems.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yswu
 * @date 2021-03-25 17:31
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;


    @Override
    public List<Employees> finaAll() {
        return empDao.findAll();
    }
}
