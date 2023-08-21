package com.cydeo.lab04springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LabController {


    @RequestMapping("/lab")
    private String labList(Model model){

        model.addAttribute("firstLab","00-coupling");
        model.addAttribute("secondLab","01-IoC");
        model.addAttribute("thirdLab","02-di");
        model.addAttribute("fourthLab","03-spring boot");
        model.addAttribute("fifthLab","04-spring mvc");

        return "/lab/lab-list";
    }



}
