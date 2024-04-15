package com.example.training_JAva6.Repository;

import com.example.training_JAva6.Entity.Product;
import com.example.training_JAva6.Entity.ProductBrand;
import com.example.training_JAva6.Entity.ProductBrandId;
import com.example.training_JAva6.ResponRrequet.ResponseProduct;
import com.example.training_JAva6.model.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductBrandRepository extends JpaRepository<ProductBrand, ProductBrandId> {
    @Query("SELECT pb FROM ProductBrand pb WHERE pb.product.id = :productId")
    List<ProductBrand> findByProductId(@Param("productId") Long productId);



    @Modifying
    @Transactional
    @Query(value = """
            UPDATE
                product_brand
            SET
                brand_id =  :#{#productBrandResponse.brandID}
            WHERE
                product_id = :#{#productBrandResponse.id}
            """, nativeQuery = true)
    void updateBrand(@Param("productBrandResponse") ResponseProduct productBrandResponse);
}
