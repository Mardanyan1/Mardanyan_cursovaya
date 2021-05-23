package com.Mardanyan.Zooshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
    @GetMapping("/food")
    public String foodmain(Model model)
    {
        return "food";
    }

}
