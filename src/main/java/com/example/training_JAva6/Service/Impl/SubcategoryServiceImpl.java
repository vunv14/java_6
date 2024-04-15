package com.example.training_JAva6.Service.Impl;

import com.example.training_JAva6.Entity.Subcategory;
import com.example.training_JAva6.Repository.SubCategoryRepository;
import com.example.training_JAva6.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubcategoryServiceImpl implements SubCategoryService {

    @Autowired
    SubCategoryRepository subCategoryRepository;
    @Override
    public List<Subcategory> listSubCategory() {
        return subCategoryRepository.getAllSubCategory();
    }
}
