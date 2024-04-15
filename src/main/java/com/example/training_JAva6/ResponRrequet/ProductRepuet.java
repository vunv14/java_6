package com.example.training_JAva6.ResponRrequet;


import com.example.training_JAva6.Entity.Brand;
import com.example.training_JAva6.Entity.Product;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRepuet {

    private String produceName;
    private String color;
    private int quantity;
    private double  sellPrice;
    private double originPrice;
    private String brandID;
    private String subCateName;

}
