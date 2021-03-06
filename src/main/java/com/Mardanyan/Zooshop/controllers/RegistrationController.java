package com.Mardanyan.Zooshop.controllers;

import com.Mardanyan.Zooshop.models.Role;
import com.Mardanyan.Zooshop.models.User;
import com.Mardanyan.Zooshop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController
{
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model)
    {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb != null)
        {
            model.addAttribute("message", "Такой пользователь уже есть!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }
}
