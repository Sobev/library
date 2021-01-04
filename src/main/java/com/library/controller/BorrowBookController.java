package com.library.controller;

import com.library.entities.BorrowBook;
import com.library.entities.returndata.BorrowNum;
import com.library.service.BorrowBookService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class BorrowBookController {
    @Autowired
    private BorrowBookService service;

    @RequestMapping("/admin/borrowbook/sbm")
    @ResponseBody
    public JSONObject setBorrowBook(@RequestBody BorrowBook borrowBook) {
        System.out.println(borrowBook.toString());
        JSONObject jo = null;
        //if (service.getStatus(borrowBook.getCardId()) == 1)
        if(service.canBorrow(borrowBook.getCardId())<=0)
            return JSONObject.parseObject(new String("{'data':'borrow fail'}"));
        else {
            borrowBook.setOutDate(new Date());
            service.setBorrowBook(borrowBook);
            service.setStatus(borrowBook.getCardId(), 1);
            service.setBorrowBook_pro(borrowBook);
            jo = JSONObject.parseObject(new String("{'data':'borrow success'}"));
            return jo;
        }
    }

    @RequestMapping("/admin/borrow/back")
    @ResponseBody
    public JSONObject backBook(@RequestBody BorrowBook borrowBook) {
        System.out.println(borrowBook.toString());
        service.backBook(borrowBook.getBookId(), borrowBook.getCardId());
        service.setStatus(borrowBook.getCardId(), 0);
        service.backBook_pro(borrowBook.getCardId());
        JSONObject jo = JSONObject.parseObject(new String("{'data':'back success'}"));
        return jo;
    }

    @RequestMapping("/admin/main/init")
    @ResponseBody
    public List<BorrowNum> borrowNum() {
        return service.borrowNumList();
    }

    @RequestMapping("/admin/main/info")
    @ResponseBody
    public List<String> aob() {
        return service.ArrearsAndOBDate();
    }

    @RequestMapping("/admin/main")
    public String mainMenu() {
        return "main";
    }
    @RequestMapping("/admin/book/outofdate")
    public String listOfOutMoney(Model model)
    {
        model.addAttribute("reader_borrow",service.reader_borrow());
        return "outdate";
    }
}
