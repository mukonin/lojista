package com.mukonin.sandbox.lojista.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Intended to verify thymeleaf view functionality
 * core/src/main/webapp/templates/index.html
 */
@Controller
@RequestMapping("/")
public class TestController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("time", LocalTime.now());
        return "index";
    }
}
