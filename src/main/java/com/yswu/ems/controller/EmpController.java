package com.yswu.ems.controller;

import com.yswu.ems.entity.Employees;
import com.yswu.ems.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author yswu
 * @date 2021-03-25 17:33
 */

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Employees> emps = empService.finaAll();

        model.addAttribute("emps",emps);
        return "/ems/emplist";

    }



}
