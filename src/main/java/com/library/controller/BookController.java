package com.library.controller;

import com.library.Interceptor.MessageSocketHandler;
import com.library.entities.Book;
import com.library.entities.returndata.ClassifyNum;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    MessageSocketHandler messageSocketHandler;

    @RequestMapping("/admin/books")
    public String intoBooks(Model model) {
        model.addAttribute("b", bookService.getByClick(0));
        //messageSocketHandler.handleTextMessage(webSocketSession,new TextMessage("某人进入页面"));
        return "books";
    }

    @RequestMapping("/admin/books/clicked")
    @ResponseBody
    public List<Book> clickBook(@RequestParam("count") Integer time) {
        System.out.println(time);
        return bookService.getByClick(Integer.valueOf(time));
    }

    @RequestMapping("/admin/book/edit/{id}")
    public String editBook(@PathVariable("id") Integer id, Model model) {
        Book book = bookService.editBook(id);
        if (book == null) return "";
        System.out.println(book.getBookId());
        model.addAttribute("editBook", book);
        return "editbooks";
    }

    @RequestMapping("/admin/book/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return "redirect:/admin/books";
    }

    @RequestMapping("/admin/bookECharts")
    @ResponseBody
    public List<ClassifyNum> getECharts() {
        List<ClassifyNum> classifyNums = bookService.getBookECharts();
        return bookService.getBookECharts();
    }

    @RequestMapping("/admin/book/publisher")
    @ResponseBody
    public List<Map<String, String>> getPublisher() {
        return bookService.getAllPublisher();
    }

    @RequestMapping("/admin/book/edit/sbm")
    @ResponseBody
    public String updateEdit(@RequestBody Book b) {
        bookService.updateBook(b);
        return "success";
    }

    @RequestMapping("/admin/book/get")
    @ResponseBody
    public Book get(@RequestParam("id") String id) {
        System.out.println(id);
        return bookService.getById(id);
    }

    @RequestMapping("/admin/book/search")
    public String search(@RequestParam String bookName, Model model) {
        System.out.println(bookName);
        Book book = bookService.findByName(bookName);
        System.out.println(book.toString());
        model.addAttribute("b", book);
        return "books";
    }

    @RequestMapping("/admin/book/addBook")
    @ResponseBody
    public String addBook(@RequestBody Book book) {
        System.out.println(book.toString());
        bookService.saveBook(book);
        return "success";
    }
}
