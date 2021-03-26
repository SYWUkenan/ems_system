package com.yswu.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author yswu
 * @date 2021-03-25 17:25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employees {
    private String id;
    private String name;
    private Double salary;
    private Integer age;
    private Date bir;
}
