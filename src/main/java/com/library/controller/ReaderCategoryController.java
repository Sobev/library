package com.library.controller;

import com.library.entities.Reader;
import com.library.entities.ReaderCategory;
import com.library.service.ReaderCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReaderCategoryController {
    @Autowired
    ReaderCategoryService service;

    @RequestMapping("/admin/readercategory")
    public String readerCategory(Model model) {
        model.addAttribute("category", service.getAll());
        return "readercategory";
    }

    @RequestMapping("/admin/category/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/admin/readercategory";
    }

    @RequestMapping("/admin/category/edit/{id}")
    public String getById(@PathVariable("id") String id, Model model) {
        ReaderCategory category = service.findById(id);
        model.addAttribute("cate", category);
        return "categoryedit";
    }

    @RequestMapping("/admin/category/update")
    @ResponseBody
    public String update(@RequestBody ReaderCategory category) {
        service.alter(category);
        return "success";
    }

    @RequestMapping("/admin/category/save")
    @ResponseBody
    public String save(@RequestBody ReaderCategory category) {
        System.out.println(category);
        service.save(category);
        return "success";
    }
}
