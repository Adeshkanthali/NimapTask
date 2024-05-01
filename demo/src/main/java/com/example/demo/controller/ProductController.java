package com.example.demo.controller;

import com.example.demo.dto.ProductCategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @PostMapping("saveProduct")
    public String saveProduct(@RequestBody Product product){
        productRepo.save(product);
        return "Product Saved Successfully";
    }

    @GetMapping("getAllProduct")
    public List<Product> getProd(){
        return productRepo.findAll();
    }

    @GetMapping("getProductWithPageable")
    public Page<Product> getProduct(Pageable pageable){
        return productRepo.findAllWithPagination(pageable);
    }

    @GetMapping("getProductById")
    public Map<Long, String> getProductById(@RequestParam Long id){
        return productRepo.getProdByID(id);
    }

    @GetMapping("getProductByIdWithCategory")
    public ProductCategoryDTO getProductByIdWithCategory(@RequestParam Long id){
        Product product = productRepo.findById(id).orElse(null);
        if (product != null && product.getCategory() != null) {
            return new ProductCategoryDTO(product.getId(),
                    product.getName(),
                    product.getCategory().getId(),
                    product.getCategory().getName());
        } else {
            return null;
        }
    }


    @PutMapping("updateProduct")
    public String updateProduct(@RequestBody ProductDTO productDTO){
        Product ct = productRepo.getReferenceById(productDTO.getId());
        ct.setName(productDTO.getName());
        productRepo.save(ct);
        return "Product Updated Successfully";
    }

    @DeleteMapping("deleteProduct")
    public String deleteProduct(@RequestBody ProductDTO productDTO){
        Product ct = productRepo.getReferenceById(productDTO.getId());
        productRepo.delete(ct);
        return "Proudct Deleted Successfully";
    }


}
