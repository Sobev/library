package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SocketController {
    @RequestMapping("admin/socket")
    public String socketTest() {
        return "/socket/socketTest";
    }
}
