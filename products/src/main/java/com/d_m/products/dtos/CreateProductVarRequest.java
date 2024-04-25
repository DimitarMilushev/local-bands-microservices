package com.d_m.products.dtos;

import jakarta.validation.constraints.NotNull;

public record CreateProductVarRequest(@NotNull Long sizeId, @NotNull double price, @NotNull int quantityAvailable) {
}
