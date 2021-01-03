package com.library.controller;

import com.library.entities.Admin;
import com.library.entities.usrpwd;
import com.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login/sbm")
    @ResponseBody
    public String checkValidate(@RequestBody usrpwd up, HttpSession session) {
        Admin admin = adminService.findAdmin(up);
        if (admin != null) {
            System.out.println(admin.toString());
            session.setAttribute("user", admin);
            return "success";
        } else return "fail";
    }

    @RequestMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }
}
