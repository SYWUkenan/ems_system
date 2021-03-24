package com.yswu.ems.controller;

import com.sun.deploy.net.HttpResponse;
import com.yswu.ems.entity.User;
import com.yswu.ems.service.UserService;
import com.yswu.ems.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    //注册方法
    public String register(User user){
        userService.register(user);
        return "redirect:/index"; //跳转到登录界面
    }


    @GetMapping("/code")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {

        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();

        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        //响应图片
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image,"png",outputStream);

    }


}
