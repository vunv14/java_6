package com.example.training_JAva6.ResponRrequet;

import com.example.training_JAva6.Entity.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ResponseProduct {

    private Long id;

    private Long subcategoryID;

    private Long brandID;

    private String produceName;

    private String color;

    private int quantity;

    private double sellPrice;

    private double originPrice;



}
