package com.example.demo.controller;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping("saveCategory")
    public String saveCategory(@RequestBody Category category){
        categoryRepo.save(category);
        return "Category Saved";
    }

    @GetMapping("getAllCategory")
    public List<Category> getAllCategory(){
        return categoryRepo.findAll();
    }

    @GetMapping("getAllCategoryWithPageable")
    public Page<Category> getAllCategory(Pageable pageable){
        return categoryRepo.findAllWithPagination(pageable);
    }

    @GetMapping("getCategoryById")
    public Map<Long, String> getCategoryById(@RequestParam Long id){
        return categoryRepo.getCategById(id);
    }

    @PutMapping("updateCateg")
    public String updateCategName(@RequestBody CategoryDTO categoryDTO){
        Category ct = categoryRepo.getReferenceById(categoryDTO.getId());
        ct.setName(categoryDTO.getName());
        categoryRepo.save(ct);
        return "Category Updated";
    }

    @DeleteMapping("deleteCateg")
    public String deleteCateg(@RequestBody CategoryDTO categoryDTO){
        Category ct = categoryRepo.getReferenceById(categoryDTO.getId());
        categoryRepo.delete(ct);
        return "Category Deleted Successfully";
    }

}
