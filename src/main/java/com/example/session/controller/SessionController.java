package com.example.session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {
    @GetMapping("get/session")
    public String getSession() {
        return "session";
    }
}
