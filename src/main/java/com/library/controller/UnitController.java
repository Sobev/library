package com.library.controller;

import com.library.entities.Unit;
import com.library.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UnitController {
    @Autowired
    UnitService service;

    @RequestMapping("/admin/unit")
    public String readerCategory(Model model) {
        model.addAttribute("unit", service.getAll());
        return "unit";
    }

    @RequestMapping("/admin/unit/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/admin/unit";
    }

    @RequestMapping("/admin/unit/edit/{id}")
    public String getById(@PathVariable("id") String id, Model model) {
        Unit unit = service.getById(id);
        model.addAttribute("unit", unit);
        return "unitedit";
    }

    @RequestMapping("/admin/unit/update")
    @ResponseBody
    public String update(@RequestBody Unit unit) {
        service.alter(unit);
        return "success";
    }

    @RequestMapping("/admin/unit/save")
    @ResponseBody
    public String save(@RequestBody Unit unit) {
        System.out.println(unit);
        service.save(unit);
        return "success";
    }

    @RequestMapping("/admin/unit/alter")
    @ResponseBody
    public String alter(@RequestBody Unit unit) {
        System.out.println(unit);
        service.alter(unit);
        return "success";
    }
}
