package com.ww.controller;

import com.ww.pojo.BackendUser;
import com.ww.pojo.DevUser;
import com.ww.service.BackendUserService;
import com.ww.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: wangwei
 * @Description: 用于后台人员登录与退出的controller
 * @Time: 2019/6/30 星期日 21:40
 **/
@Controller
@RequestMapping("/backend")
public class BackendUserController {

    @Autowired
    private BackendUserService backendUserService;

    @RequestMapping("/login")
    public String login(BackendUser backendUser, Model model, HttpSession session){
        BackendUser backendUserRes = backendUserService.login(backendUser);
        if (backendUserRes != null) {
            session.removeAttribute("devUser");
            session.setAttribute("backendUser",backendUserRes);
            return "backend/index";
        }else {
            model.addAttribute("errMsg","用户名或密码错误");
            return "forward:/";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("backendUser");
        session.invalidate();
        return "redirect:/";
    }
}
