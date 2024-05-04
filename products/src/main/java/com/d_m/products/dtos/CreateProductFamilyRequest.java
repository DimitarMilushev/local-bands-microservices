package com.d_m.products.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateProductFamilyRequest(@NotEmpty String name, @NotNull Long[] ids) {
}
