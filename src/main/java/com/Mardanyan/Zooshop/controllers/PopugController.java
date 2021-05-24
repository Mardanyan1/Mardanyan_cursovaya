package com.Mardanyan.Zooshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class PopugController
{
    @GetMapping("/popugs")
    public String home(Model model)
    {
        model.addAttribute("title", "Попугаи");
        return "popugs";
    }
}