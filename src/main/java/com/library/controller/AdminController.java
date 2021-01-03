package com.library.controller;

import com.library.entities.Admin;
import com.library.entities.returndata.IndexCharts;
import com.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/getAll")
    public String getAllAdmin(Model model) {
        List<Admin> admins = adminService.findAdminByClick(0);
        model.addAttribute("admin", admins);
        return "index";
    }

    @RequestMapping("/getAllAdmins")
    @ResponseBody
    public List<Admin> getAllAdm(Model model) {
        List<Admin> admins = adminService.findAll();
        return admins;
    }

    @RequestMapping("/getAdminsByClick")
    @ResponseBody
    public List<Admin> getAdminByClickTime(@RequestParam("count") String count) {
        List<Admin> admins = adminService.findAdminByClick(Integer.valueOf(count));
        return admins;
    }


    @GetMapping("/admin")
    public String index() {
        return "addadmin";
    }

    @RequestMapping("/sbm")
    @ResponseBody
    public String submit(@RequestBody Admin admin) {
        adminService.AddAdmin(admin);
        return "success";
    }

    @RequestMapping("/getCharts")
    @ResponseBody
    public IndexCharts getCharts() {
        return adminService.findOnlineAndAll();
    }

    @RequestMapping("/admin/main/active")
    @ResponseBody
    public List<Admin> getActive() {
        return adminService.findActive();
    }
}
