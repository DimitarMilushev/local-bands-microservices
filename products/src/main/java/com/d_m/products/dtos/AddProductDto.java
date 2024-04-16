package com.d_m.products.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddProductDto implements Serializable {
    private String name;
    private String description;
    private String[] images;
    private double price;
}
