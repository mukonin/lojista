package com.mukonin.sandbox.lojista.core.controller;

import com.mukonin.sandbox.lojista.core.service.DeliveryUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Intended to verify security functionality
 * core/src/main/webapp/templates/manager.html
 */
@Controller
@RequestMapping("/mgr")
public class ManagerController {

    private final DeliveryUnitService deliveryUnitService;

    @Autowired
    public ManagerController(DeliveryUnitService deliveryUnitService) {
        this.deliveryUnitService = deliveryUnitService;
    }


    @GetMapping
    public String index(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("deliveries", deliveryUnitService.getAllAsDTO());
        model.addAttribute("user", userDetails.getUsername());
        return "manager";
    }
}
