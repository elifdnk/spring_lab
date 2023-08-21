package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class ProfileController {


    @RequestMapping("/profile")
    public String getProfile(Model model) {

        Profile person = new Profile();
        person.setName("Elif");
        person.setSurname("Denk");
        person.setUserName("admin");
        person.setEmail("elif@gmail.com");
        person.setCreatedDate(LocalDateTime.now());

        model.addAttribute(person);
        return ("/profile/profile-info");


    }
}
