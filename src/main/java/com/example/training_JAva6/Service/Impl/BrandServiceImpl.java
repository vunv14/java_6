package com.example.training_JAva6.Service.Impl;

import com.example.training_JAva6.Entity.Brand;
import com.example.training_JAva6.Repository.BrandRepository;
import com.example.training_JAva6.Service.Brandservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BrandServiceImpl implements Brandservice {
    @Autowired
    BrandRepository brandRepository;

    @Autowired

    @Override
    public List<Brand> findAll() {
        return brandRepository.getListAll();
    }

    @Override
    public Brand getBrand(Long productID) {
        Brand brand = brandRepository.findBrandByIdProdutc(productID);
        return brand;
    }


}
