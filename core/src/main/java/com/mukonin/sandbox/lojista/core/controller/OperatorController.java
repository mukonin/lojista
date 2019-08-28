package com.mukonin.sandbox.lojista.core.controller;

import com.mukonin.sandbox.lojista.core.service.ParcelService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Intended to verify security functionality
 * core/src/main/webapp/templates/operator.html
 */
@Controller
@RequestMapping("/opr")
public class OperatorController {
    private final ParcelService parcelService;

    public OperatorController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @GetMapping
    public String index(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("parcels", parcelService.getAllAsParcelDTO());
        model.addAttribute("user", userDetails.getUsername());
        return "operator";
    }
}
