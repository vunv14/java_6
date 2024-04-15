package com.example.training_JAva6.controller;

import com.example.training_JAva6.Entity.Brand;
import com.example.training_JAva6.Entity.Product;
import com.example.training_JAva6.ResponRrequet.ResponseProduct;
import com.example.training_JAva6.Service.Brandservice;
import com.example.training_JAva6.Service.ProductService;
import com.example.training_JAva6.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    BrandController brandController;

    @Autowired
    ProductController productController;

    @Autowired
    SubCategoryController subCategoryController;

    @Autowired
    StatusController statusController;

    @Autowired
    ProductService productService;


    @Autowired
    Brandservice brandservice;


    @Autowired
    SubCategoryService subCategoryService;


    @GetMapping("/view")
    public String ViewHome(Model model){
        productController.ViewHomePage(model);
        return "index";
    }



    @GetMapping("/showNewProductForm")
    public String item(Model model){
        productController.showNewProductForm(model);
        brandController.itemComBox(model);
        subCategoryController.itemComboxsubcategoryProduct(model);
        return "Addproduct";
    }

    @GetMapping("/viewUpdate/{id}")
    public String showFormUpdate(@PathVariable(value = "id") long id, Model model){
        List<Brand> brands = brandservice.findAll();
        model.addAttribute("listBrandController", brands);
        model.addAttribute("listcomboxSubcategory", subCategoryService.listSubCategory());
        Product product = productService.getProductId(id);
        Brand brand = brandservice.getBrand(id);

        var reponse = ResponseProduct.builder()
                .brandID(brand.getId())
                .color(product.getColor())
                .originPrice(product.getOriginPrice())
                .produceName(product.getProduceName())
                .sellPrice(product.getSellPrice())
                .subcategoryID(product.getSubcategory().getId())
                .id(id)
                .build();

        model.addAttribute("reponse", reponse);

        return "UpdateProduct";
    }


    @GetMapping("/viewDelete/{id}")
    public String showFormDelete(@PathVariable(value = "id") long id , Model model){
        List<Brand> brands = brandservice.findAll();
        model.addAttribute("listBrandController", brands);
        model.addAttribute("listcomboxSubcategory", subCategoryService.listSubCategory());
        Product product = productService.getProductId(id);
        Brand brand = brandservice.getBrand(id);

        var reponse = ResponseProduct.builder()
                .brandID(brand.getId())
                .color(product.getColor())
                .originPrice(product.getOriginPrice())
                .produceName(product.getProduceName())
                .sellPrice(product.getSellPrice())
                .subcategoryID(product.getSubcategory().getId())
                .id(id)
                .build();

        model.addAttribute("viewdelete", reponse);
        productService.deleteProduct(id);
        return "RemoveProduct";
    }












}
