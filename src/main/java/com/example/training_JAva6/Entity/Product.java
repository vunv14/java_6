package com.example.training_JAva6.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue ( strategy =  GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sub_cate_id", referencedColumnName = "id")
    private Subcategory subcategory;

    private String produceName;
    private String color;

    private int quantity;

    private double sellPrice;

    private double originPrice;

    private String description;

    public Product( String produceName, String color, int quantity, double sellPrice, double originPrice,  Subcategory subcategory) {

        this.produceName = produceName;
        this.color = color;
        this.quantity = quantity;
        this.sellPrice = sellPrice;
        this.originPrice = originPrice;
        this.status = status;
        this.subcategory = subcategory;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;


}
