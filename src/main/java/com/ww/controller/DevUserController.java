package com.ww.controller;

import com.ww.pojo.DevUser;
import com.ww.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * @Author: wangwei
 * @Description: 用于开发者登录域与推出的controller
 * @Time: 2019/6/30 星期日 21:40
 **/
@Controller
@RequestMapping("/dev")
public class DevUserController {

    @Autowired
    private DevUserService devUserService;

    @RequestMapping("/login")
    public String login(DevUser devUser, Model model, HttpSession session){
        DevUser devUserRes = devUserService.login(devUser);
        if (devUserRes != null) {
            session.removeAttribute("backendUser");
            session.setAttribute("devUser",devUserRes);
            return "dev/index";
        }else {
            model.addAttribute("errMsg","用户名或密码错误");
            return "forward:/";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("devUser");
        session.invalidate();
        return "redirect:/";
    }
}
