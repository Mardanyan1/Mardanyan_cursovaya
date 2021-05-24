package com.Mardanyan.Zooshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DogsController {

    @GetMapping("/dogs")
    public String dog(Model model)
    {
        model.addAttribute("title", "Собаки");
        return "dogs";
    }

}