//package com.example.training_JAva6.RestController;
//
//import com.example.training_JAva6.Entity.Product;
//import com.example.training_JAva6.Repository.ProductRepository;
//import com.example.training_JAva6.Service.Impl.ProductImpl;
//import com.example.training_JAva6.Service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class ProductRestController {
//
//    @Autowired
//   private ProductService product;
//
//    public ProductRestController(ProductService product) {
//        this.product = product;
//    }
//
//
//    @GetMapping("/findall")
//    public ResponseEntity<List<Product>> findAll(){
//        List<Product> list = product.FindAllProducts();
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
//
//
//}
