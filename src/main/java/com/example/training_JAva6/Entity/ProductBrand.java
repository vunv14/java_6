package com.example.training_JAva6.Entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "product_brand")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@IdClass(ProductBrandId.class)
@Embeddable
public class ProductBrand implements Serializable {

    @Id
    @Column(name = "product_id")
    private Long productId;

    @Id
    @Column(name = "brand_id")
    private Long brandId;


    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Brand brand;


}
