package com.d_m.products.products.base.dtos;

import com.d_m.products.categories.CategoryEntity;
import com.d_m.products.colors.ColorsEntity;
import com.d_m.products.genders.Gender;
import com.d_m.products.products.variations.ProductsSizeVariation;

import java.util.List;

public record ProductResponse(String name,
                              String description,
                              String[] images,
                              CategoryEntity category,
                              ColorsEntity color,
                              Gender gender,
                              List<ProductsSizeVariation> availableSizes) {
}
