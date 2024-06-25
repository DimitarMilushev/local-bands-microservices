package com.d_m.products.products.base.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProductRequest(
        @NotNull Long colorId,
        @NotBlank String name,
        @NotBlank String description,
        @NotNull String[] imageUrls,
        @NotNull Long categoryId,
        @NotNull Long genderId
) {
}
