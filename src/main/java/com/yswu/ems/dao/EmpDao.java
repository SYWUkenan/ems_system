package com.yswu.ems.dao;

import com.yswu.ems.entity.Employees;

import java.util.List;

/**
 * @author yswu
 * @date 2021-03-25 17:27
 */
public interface EmpDao {
    List<Employees> findAll();
    void save(Employees employees);
    void delete(String id);
    Employees find(String id);
    void update(Employees employees);
}
