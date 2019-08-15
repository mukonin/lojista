package com.mukonin.sandbox.lojista.core.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Intended to verify security functionality
 * core/src/main/webapp/templates/operator.html
 */
@Controller
@RequestMapping("/opr")
public class OperatorController {

    @GetMapping
    public String index(Model model){
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("time", LocalTime.now());
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("user", context.getAuthentication().getName());
        return "operator";
    }
}
