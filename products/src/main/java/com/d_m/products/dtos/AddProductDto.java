package com.d_m.products.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record AddProductDto(
        @NonNull() String name,
        @NonNull() String description,
        @NonNull() String[] images,
        @NonNull() @JsonProperty("SKU") String SKU,
        double price,
        Long colorId,
        @NonNull() Long categoryId,
        Long discountId) {
}
