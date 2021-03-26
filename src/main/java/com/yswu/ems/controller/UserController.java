package com.yswu.ems.controller;

import com.yswu.ems.entity.User;
import com.yswu.ems.service.UserService;
import com.yswu.ems.utils.ValidateImageCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author yswu
 * @date 2021-03-23 17:17
 */

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //登录方法
    @PostMapping("/login")
    public String login(String username,String password){
        User user = userService.login(username, password);

        if(user!=null){
            return "redirect:/emp/findAll";//跳转到员工界面
        }else{
            return "redirect:/index";//跳转到登录界面
        }

    }


    //注册方法
    @PostMapping("/register")
    public String register(User user,String code,HttpSession session){
        String sessionCode = (String) session.getAttribute("code");
        log.info("{}",sessionCode);
        if(code.equalsIgnoreCase(sessionCode)){
            userService.register(user);
            return "redirect:/index"; //跳转到登录界面

        }else{

            return "redirect:/toRegister";
        }



    }


    @GetMapping("/code")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {

        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();

        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);

        //存入session中

        session.setAttribute("code",securityCode);
        //响应图片
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image,"png",outputStream);

    }


}
