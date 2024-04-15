package com.example.training_JAva6.Repository;

import com.example.training_JAva6.Entity.Product;
import com.example.training_JAva6.Entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<Subcategory,Long> {
    @Query(
            value = """
        select sc.id,sc.sub_cate_name ,sc.sub_cate_code,sc.cate_id from sub_category sc
                                                              
""", nativeQuery = true

    )
    List<Subcategory> getAllSubCategory();
    @Query("SELECT s FROM Subcategory s WHERE s.id = :productId")
    List<Subcategory> findByProductId(@Param("productId") Long productId);
}
