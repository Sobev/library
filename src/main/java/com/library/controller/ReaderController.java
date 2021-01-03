package com.library.controller;

import com.library.entities.Publishing;
import com.library.entities.Reader;
import com.library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@Controller
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @RequestMapping("/admin/reader")
    public String Init(Model model) {
        model.addAttribute("reader", readerService.getAll());
        return "reader";
    }

    @RequestMapping("/admin/reader/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        readerService.delete(id);
        return "redirect:/admin/reader";
    }

    @RequestMapping("/admin/reader/edit/{id}")
    public String getById(@PathVariable("id") String id, Model model) {
        Reader reader = readerService.getById(id);
        model.addAttribute("reader", reader);
        return "readeredit";
    }

    @RequestMapping("/admin/reader/update")
    @ResponseBody
    public String update(@RequestBody Reader reader) {
        System.out.println(reader);
        readerService.alter(reader);
        return "success";
    }

    @RequestMapping("/admin/reader/save")
    @ResponseBody
    public String save(@RequestBody Reader reader) {
        reader.setCardId(UUID.randomUUID().toString());
        reader.setDate(new Date());
        System.out.println(reader);
        readerService.save(reader);
        return "success";
    }
}
