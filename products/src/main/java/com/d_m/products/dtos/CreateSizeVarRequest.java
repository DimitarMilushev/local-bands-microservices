package com.d_m.products.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateSizeVarRequest(@NotEmpty String categoryCode,
                                   @NotEmpty String colorCode,
                                   @NotEmpty String genderCode,
                                   @NotNull Long productId,
                                   @NotNull Long sizeId,
                                   @NotBlank String description,
                                   @NotNull double price,
                                   @NotNull int quantityAvailable) {
}
