package com.example.training_JAva6.controller;

import com.example.training_JAva6.Entity.Brand;
import com.example.training_JAva6.Service.Brandservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/viewbrand")
@Controller
public class BrandController {
    @Autowired
    Brandservice brandservice;


    public String itemComBox(Model model) {
        List<Brand> brands = brandservice.findAll();
        model.addAttribute("listBrandController", brands);
        return "index";
    }




}

