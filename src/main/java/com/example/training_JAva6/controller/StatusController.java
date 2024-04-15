package com.example.training_JAva6.controller;


import com.example.training_JAva6.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping("/comboxStatus")
    public String itemComboxStatus(Model model){
        model.addAttribute("listItemStatus", statusService.getAllStatus());
        return "index";
    }
}
