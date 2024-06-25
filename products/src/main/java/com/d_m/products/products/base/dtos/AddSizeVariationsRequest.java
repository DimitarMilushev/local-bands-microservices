package com.d_m.products.products.base.dtos;

import jakarta.validation.constraints.NotNull;

public record AddSizeVariationsRequest(@NotNull Long[] ids) {
}
