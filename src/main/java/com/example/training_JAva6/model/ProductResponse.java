package com.example.training_JAva6.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductResponse {
    Long getId();
    String getProductName();
    String getBrandName();
    String getSubCateName();
    double getSellPrice();
    int getStatusId();
    String getStatusName();

}
