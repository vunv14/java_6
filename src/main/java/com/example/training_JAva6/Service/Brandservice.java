package com.example.training_JAva6.Service;

import com.example.training_JAva6.Entity.Brand;

import java.util.List;

public interface Brandservice {
    List<Brand> findAll();
    Brand getBrand(Long productID);
}
