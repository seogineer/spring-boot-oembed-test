package com.seogineer.springbootoembedtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OembedController {
    @GetMapping("/")
    public String main() {
        return "main";
    }
}