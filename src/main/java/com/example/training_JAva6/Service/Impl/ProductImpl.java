package com.example.training_JAva6.Service.Impl;

import com.example.training_JAva6.Entity.Brand;
import com.example.training_JAva6.Entity.Product;
import com.example.training_JAva6.Entity.ProductBrand;
import com.example.training_JAva6.Entity.Subcategory;
import com.example.training_JAva6.Repository.BrandRepository;
import com.example.training_JAva6.Repository.ProductBrandRepository;
import com.example.training_JAva6.Repository.ProductRepository;
import com.example.training_JAva6.Repository.StatusRepository;
import com.example.training_JAva6.Repository.SubCategoryRepository;
import com.example.training_JAva6.ResponRrequet.ProductRepuet;
import com.example.training_JAva6.ResponRrequet.ResponseProduct;
import com.example.training_JAva6.Service.ProductService;
import com.example.training_JAva6.model.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {


    private final ProductRepository productRepository;

    private final SubCategoryRepository subCategoryRepository;

    private final BrandRepository brandRepository;

    private final ProductBrandRepository productBrandRepository;

    private final StatusRepository statusRepository;








    @Override
    public Page<ProductResponse> FindAllProducts(int pageNum, String sortField, String sortDir, String productName,String sellPrice, Long  brandName,Long subcategory) {
                Pageable pageable = PageRequest.of(pageNum - 1, 5,sortDir.equals("asc") ? Sort.by(sortField).ascending(): Sort.by(sortField).descending()
        );
        return productRepository.getListProduct(pageable,productName, sellPrice,brandName,subcategory);
    }

    @Override
    public void saveProduct(ProductRepuet repuet) {
        Optional<Subcategory> subcategory = subCategoryRepository.findById(Long.valueOf(repuet.getSubCateName()));
        Optional<Brand> optionalBrand = brandRepository.findById(Long.valueOf(repuet.getBrandID()));
//        if (subcategory.isEmpty()) {
//            throw new RuntimeException("không tồn tại");
//        }
//        if (optionalBrand.isEmpty()) {
//            throw new RuntimeException("không tồn tại");
//        }

        Product product = new Product();
        product.setSubcategory(subcategory.get());
        product.setProduceName(repuet.getProduceName());
        product.setQuantity(repuet.getQuantity());
        product.setSellPrice(repuet.getSellPrice());
        product.setColor(repuet.getColor());
        product.setOriginPrice(repuet.getOriginPrice());
        productRepository.save(product);

//        ProductBrand productBrand =  new ProductBrand();
//        productBrand.setBrandId(optionalBrand.get().getId());
//        productBrand.setProductId(product.getId());
//        productBrandRepository.save(productBrand);
        ProductBrand productBrand = ProductBrand.builder()
                .productId(product.getId())
                .brandId(optionalBrand.get().getId())
                .build();
        productBrandRepository.save(productBrand);

    }



    @Override
    public void deleteProduct(Long productId) {
        List<ProductBrand> productBrandList = productBrandRepository.findByProductId(productId);
        productBrandRepository.deleteAll(productBrandList);
        productRepository.deleteById(productId);

    }

    @Override
    public Product getProductId(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product  = optionalProduct.get();
        return product;
    }

    @Override
    public Product update(ResponseProduct responseProduct) {
        Optional<Subcategory> subcategory = subCategoryRepository.findById(Long.valueOf(responseProduct.getSubcategoryID()));
        Optional<Brand> optionalBrand = brandRepository.findById(Long.valueOf(responseProduct.getBrandID()));
        Product product = productRepository.findById(responseProduct.getId()).get();
        product.setSubcategory(subcategory.get());
        product.setProduceName(responseProduct.getProduceName());
        product.setOriginPrice(responseProduct.getOriginPrice());
        product.setQuantity(responseProduct.getQuantity());
        product.setColor(responseProduct.getColor());
        product.setSellPrice(responseProduct.getSellPrice());

        productBrandRepository.updateBrand(responseProduct);

        productRepository.save(product);

        return product;
    }





}
