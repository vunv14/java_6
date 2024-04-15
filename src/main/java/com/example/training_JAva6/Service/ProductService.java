package com.example.training_JAva6.Service;

import com.example.training_JAva6.Entity.Product;
import com.example.training_JAva6.ResponRrequet.ProductRepuet;
import com.example.training_JAva6.ResponRrequet.ResponseProduct;
import com.example.training_JAva6.model.ProductResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Page<ProductResponse> FindAllProducts(int pageNum,String sortField, String sortDir, String productName,String sellPrice, Long  brandName,Long subcategory);
    void saveProduct(ProductRepuet productRepuet);

    void deleteProduct(Long productId);

    Product getProductId(Long id);

    Product update (ResponseProduct responseProduct);


}
