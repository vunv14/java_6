package com.example.training_JAva6.Service.Impl;

import com.example.training_JAva6.Entity.ProductBrand;
import com.example.training_JAva6.Entity.ProductBrandId;
import com.example.training_JAva6.Repository.ProductBrandRepository;
import com.example.training_JAva6.Service.productBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductBrandImpl implements productBrandService {

    @Autowired
    ProductBrandRepository productBrandRepository;
    @Override
    public void deleteProductBrand(long productId) {
        productBrandRepository.deleteById(ProductBrandId.builder().build());
    }
}
