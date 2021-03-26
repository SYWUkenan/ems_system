package com.yswu.ems.controller;

import com.yswu.ems.dao.EmpDao;
import com.yswu.ems.entity.Employees;
import com.yswu.ems.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author yswu
 * @date 2021-03-25 17:33
 */

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 查询所有员工
     * @param model
     * @return
     */
    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Employees> emps = empService.finaAll();

        model.addAttribute("emps",emps);
        return "/ems/emplist";

    }


    /**
     * 保存员工
     * @param employees
     * @return
     */
    @PostMapping("/save")
    public String save(Employees employees){
        employees.setId(UUID.randomUUID().toString());
        empService.save(employees);
        return "redirect:/emp/findAll";

    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(String id){
        empService.delete(id);
        return "redirect:/emp/findAll";
    }

    /**
     * 查询单个员工
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/find")
    public String find(String id,Model model){
        Employees employees = empService.find(id);
        model.addAttribute("emp",employees);
        return "/ems/updateEmp";

    }

   @RequestMapping("/update")
    public String update(Employees employees){
       empService.update(employees);
       return "redirect:/emp/findAll";

   }



}
