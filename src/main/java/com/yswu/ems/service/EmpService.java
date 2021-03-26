package com.yswu.ems.service;

import com.yswu.ems.entity.Employees;

import java.util.List;

/**
 * @author yswu
 * @date 2021-03-25 17:31
 */
public interface EmpService {

    List<Employees> finaAll();
    void save(Employees employees);
    void delete(String id);
    Employees find(String id);
    void update(Employees employees);
}
