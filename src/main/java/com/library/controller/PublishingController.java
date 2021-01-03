package com.library.controller;

import com.library.entities.Publishing;
import com.library.service.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PublishingController {
    @Autowired
    private PublishingService service;

    @RequestMapping("/admin/publishing/update")
    @ResponseBody
    public String update(@RequestBody Publishing publishing) {
        System.out.println(publishing.toString());
        service.alter(publishing);
        return "success";
    }

    @RequestMapping("/admin/publishing/save")
    @ResponseBody
    public String save(@RequestBody Publishing publishing) {
        System.out.println(publishing.toString());
        service.save(publishing);
        return "success";
    }

    @RequestMapping("/admin/publishing/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/admin/publishing";
    }

    @RequestMapping("/admin/publishing")
    public String getAll(Model model) {
        model.addAttribute("publish", service.getAll());
        return "publishing";
    }

    @RequestMapping("/admin/publishing/edit/{id}")
    public String getById(@PathVariable("id") String id, Model model) {
        Publishing p = service.getById(id);
        model.addAttribute("publish", p);
        return "publishingedit";
    }
}
