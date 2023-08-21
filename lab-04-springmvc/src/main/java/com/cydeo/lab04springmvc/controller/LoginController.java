package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login/{email}/{phone}")
    public String login(@PathVariable String email,@PathVariable String phone, Model model){


        model.addAttribute("email",email);
        model.addAttribute("phoneNumber",phone);
        model.addAttribute("loginMessage","Login successful");

        return "/login/login-info";
    }
}
