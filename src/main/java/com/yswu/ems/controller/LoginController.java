package com.yswu.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yswu
 * @date 2021-03-22 16:37
 */

@Controller

public class LoginController {

    @GetMapping("/index")
    public String toIndex(){
        return "/ems/login";
    }

    @GetMapping("toRegister")
    public String toRegister(){
        return "/ems/regist";
    }

    @GetMapping("/toSave")
    public String toSave(){
        return "/ems/addEmp";
    }

}
