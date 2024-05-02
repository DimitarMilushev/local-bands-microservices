package com.d_m.products.dtos;

import jakarta.validation.constraints.NotNull;

public record AddSizeVariationsRequest(@NotNull Long[] ids) {
}
