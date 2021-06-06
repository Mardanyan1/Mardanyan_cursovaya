package com.Mardanyan.Zooshop.controllers;

import com.Mardanyan.Zooshop.models.Product;
import com.Mardanyan.Zooshop.models.ProductType;
import com.Mardanyan.Zooshop.repository.ProductRepository;
import com.Mardanyan.Zooshop.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController
{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("name","Авторизация");
        return "login";
    }

    @GetMapping("/us")
    public String us(Model model)
    {
        model.addAttribute("name","О нас");
        return "us";
    }

    @GetMapping("/animals")
    public String animals(Model model)
    {
        Iterable<ProductType> types =productTypeRepository.findAll();
        Map<ProductType, List<Product>> map = new HashMap<>();
        types.forEach(type -> map.put(type, productRepository.findByProductType(type)));
        model.addAttribute("map", map);
        return "animals";
    }
}


