package com.d_m.products.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateApparelRequest(
        @NotNull Long colorId,
        @NotBlank String SKU,
        @NotBlank String name,
        @NotBlank String description,
        @NotNull String[] imageUrls,
        @NotNull Long categoryId
) {
}
