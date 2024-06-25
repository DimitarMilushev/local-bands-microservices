package com.d_m.products.products.families.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateProductFamilyRequest(@NotEmpty String name, @NotNull Long[] ids) {
}
