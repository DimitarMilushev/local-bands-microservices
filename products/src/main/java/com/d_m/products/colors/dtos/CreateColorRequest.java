package com.d_m.products.colors.dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateColorRequest(
        @NotBlank String name, @NotBlank String hex
        ) {
}
