package com.example.training_JAva6.controller;

import com.example.training_JAva6.Entity.Product;
import com.example.training_JAva6.Entity.Subcategory;
import com.example.training_JAva6.Repository.ProductRepository;
import com.example.training_JAva6.ResponRrequet.ProductRepuet;
import com.example.training_JAva6.ResponRrequet.ResponseProduct;
import com.example.training_JAva6.Service.Impl.ProductBrandImpl;
import com.example.training_JAva6.Service.ProductService;
import com.example.training_JAva6.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;


    @Autowired
    ProductBrandImpl productBrand;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandController brandController;

    @Autowired
    StatusController statusController;

    @Autowired
    SubCategoryController subCategoryController;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("/page/{pageNum}")
    public String listByPage(Model model, @PathVariable("pageNum") int currentPage,
                             @RequestParam(name = "sortField", defaultValue = "productName") String sortField,
                             @RequestParam(name = "sortDir", defaultValue = "asc") String sortDir,
                             @RequestParam(name = "productName", required = false) String productName,
                             @RequestParam(name = "brandName", required = false) Long brandName,
                             @RequestParam(name = "subcategory", required = false)  Long  subcategory,
                             @RequestParam(name = "sellPrice" , required = false)  String sellPrice) {
        Page<ProductResponse> page;
        page =  productService.FindAllProducts(currentPage,sortField,sortDir,productName,sellPrice,brandName,subcategory);
//        page = productService.FindAllProducts(currentPage,sortField,sortDir);
        List<ProductResponse> listProduct = page.getContent();
        Long totalItem = page.getTotalElements();
        int totalPages = page.getTotalPages();
        // Load combobox data
        brandController.itemComBox(model);
        subCategoryController.itemComboxSubcategory(model);
        statusController.itemComboxStatus(model);

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalItem", totalItem);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listProduct", listProduct);

        return "index";
    }
    @GetMapping("/viewProduct")
    public String ViewHomePage(Model model) {

        return listByPage(model, 1, "id", "desc", null, null, null,  "");

    }

    // View nút add
    @GetMapping("/viewAddproduct")
    public String showNewProductForm(Model model) {
        ProductRepuet product = new ProductRepuet();
        model.addAttribute("product", product);
        return "Addproduct";
    }
    //view nut update


    @PostMapping("/saveProduct")
    public String saveEmployee(@ModelAttribute("product") ProductRepuet productRepuet, BindingResult result) {
        // save employee to database
        if (result.hasErrors()) {
            return "showNewProductForm";
        }
        productService.saveProduct(productRepuet);
        return "redirect:/view";
    }

    @PostMapping("/update-product")
    public String updateEmployee(@ModelAttribute("reponse") ResponseProduct productRepuet, BindingResult result, Model model) {
        // save employee to database
        if (result.hasErrors()) {
            return "showNewProductForm";
        }

        productService.update(productRepuet);
        System.out.println(productRepuet);
        model.addAttribute("listProduct", productRepuet);
        return "redirect:/view";
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@ModelAttribute("viewdelete") ResponseProduct productRepuet, BindingResult result, Model model) {
        // save employee to database
        if (result.hasErrors()) {
            return "showNewProductForm";
        }
        model.addAttribute("listProduct", productRepuet);
        return "redirect:/view";
    }


}
