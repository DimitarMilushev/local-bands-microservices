package com.d_m.products.products.variations.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateSizeVarRequest(@NotEmpty String categoryCode,
                                   @NotEmpty String colorCode,
                                   @NotEmpty String genderCode,
                                   @NotNull Long productId,
                                   @NotNull Long sizeId,
                                   @NotNull double price,
                                   @NotNull int quantityAvailable) {
}
