package com.example.training_JAva6.Repository;

import com.example.training_JAva6.Entity.Brand;
import com.example.training_JAva6.Entity.Product;
import com.example.training_JAva6.model.ProductResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(
            value = """
 SELECT pr.id AS id,
        pr.produce_name AS productName,
        br.brand_name AS brandName,
        sbc.sub_cate_name AS subCateName,
        pr.sell_price AS sellPrice,
        stt.status_name AS statusName
 FROM product AS pr
 LEFT JOIN product_brand AS pb ON pr.id = pb.product_id
 LEFT JOIN brand AS br ON br.id = pb.brand_id
 LEFT JOIN sub_category AS sbc ON pr.sub_cate_id = sbc.id
 LEFT JOIN status AS stt ON stt.id = pr.status_id
 WHERE (:productName IS NULL OR :productName = '' or pr.produce_name LIKE CONCAT('%', :productName, '%'))
                                     and (:sellPrice IS NULL OR :sellPrice = ' ' or pr.sell_price LIKE CONCAT('%', :sellPrice, '%'))            
                                       and (:brandName IS NULL OR :brandName = 1 or br.id = :brandName)                   
                                             and (:subCategory IS NULL OR :subCategory = 1 or sbc.id = :subCategory)                                                             
                                     """,
            nativeQuery = true)
    Page<ProductResponse> getListProduct(Pageable pageable,
                                         @Param("productName") String productName,
                                         @Param("sellPrice") String sellPrice,
                                         @Param("brandName") Long  brandName,
                                         @Param("subCategory") Long subcategory
                                      );

  }
