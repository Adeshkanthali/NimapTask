package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface ProductRepo extends JpaRepository<Product,Long> {

    @Query(value = "select * from Product where id = ?1", nativeQuery = true)
    Map<Long, String> getProdByID(Long id);

    @Query(value = "SELECT p FROM Product p", countQuery = "SELECT count(p) FROM Product p")
    Page<Product> findAllWithPagination(Pageable pageable);

}
