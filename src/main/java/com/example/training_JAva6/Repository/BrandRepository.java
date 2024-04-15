package com.example.training_JAva6.Repository;
import com.example.training_JAva6.Entity.Brand;
import com.example.training_JAva6.model.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query(
            value = """
              select br.id ,br.brand_name  from brand br
""",
            nativeQuery = true)
    List<Brand> getListAll();


    @Query("SELECT b FROM ProductBrand pb LEFT JOIN Brand b ON pb.brandId = b.id WHERE pb.productId = :idProduct")
    Brand findBrandByIdProdutc(Long idProduct);

    @Modifying
    @Transactional
    @Query(value = """
            UPDATE
                product
            SET
                product_name = :#{#productBrandResponse.productName},
                color = :#{#productBrandResponse.color},
                quantity = :#{#productBrandResponse.quantity},
                sell_price = :#{#productBrandResponse.sellPrice},
                origin_price = :#{#productBrandResponse.originPrice},
                sub_cate_id = :#{#productBrandResponse.subCateId},
                status_id = :#{#productBrandResponse.statusId}
            WHERE
                product_id = :#{#productBrandResponse.productId}
            """, nativeQuery = true)
    void updateProduct(@Param("productBrandResponse") ProductResponse productBrandResponse);

}
