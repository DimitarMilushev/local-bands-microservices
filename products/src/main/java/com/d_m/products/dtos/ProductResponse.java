package com.d_m.products.dtos;

import com.d_m.products.models.CategoryEntity;
import com.d_m.products.models.ColorsEntity;
import com.d_m.products.models.Gender;
import com.d_m.products.models.ProductsSizeVariation;

import java.util.List;

public record ProductResponse(String name,
                              String description,
                              String[] images,
                              CategoryEntity category,
                              ColorsEntity color,
                              Gender gender,
                              List<ProductsSizeVariation> availableSizes) {
}
