package com.example.training_JAva6.controller;


import com.example.training_JAva6.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubCategoryController {

    @Autowired
    SubCategoryService subCategoryService;

    @GetMapping("/comboxSubcategiry")
    public String itemComboxSubcategory(Model model){

        model.addAttribute("listcomboxSubcategory", subCategoryService.listSubCategory());
        return "index.html";
    }


    public String itemComboxsubcategoryProduct(Model model){
        model.addAttribute("listcomboxSubcategory", subCategoryService.listSubCategory());
        return "Addproduct";
    }
}
