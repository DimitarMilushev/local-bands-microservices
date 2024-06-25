package com.d_m.products.discounts.dtos;

public record CreateDiscountRequest(
        String name,
        String description,
        double percentage,
        boolean active
) {
}
