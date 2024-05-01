package com.example.demo.repository;

import com.example.demo.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query(value = "select * from Category where id = ?1", nativeQuery = true)
    Map<Long,String> getCategById(Long id);

    @Query(value = "SELECT c FROM Category c", countQuery = "SELECT count(c) FROM Category c")
    Page<Category> findAllWithPagination(Pageable pageable);

}
