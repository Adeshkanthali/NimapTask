package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategoryDTO {

    private Long prodId;
    private String prodName;
    private Long categId;
    private String categName;

    public ProductCategoryDTO(Long prodId, String prodName, Long categId, String categName) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.categId = categId;
        this.categName = categName;
    }

}
