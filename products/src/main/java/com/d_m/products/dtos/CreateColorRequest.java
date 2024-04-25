package com.d_m.products.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateColorRequest(
        @NotBlank String name, @NotBlank String hex
        ) {
}
