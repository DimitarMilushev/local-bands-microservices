package com.d_m.products.dtos;

import lombok.Data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class AddProductDto implements Serializable {
    @lombok.NonNull() 
    private String name;

    @lombok.NonNull() 
    private String description;

    @lombok.NonNull() 
    private String[] images;
    
    @lombok.NonNull() 
    @JsonProperty("SKU")
    private String SKU;
    
    private double price;

    private Long colorId;
    
    @lombok.NonNull() 
    private Long categoryId;

    private Long discountId; 
}
