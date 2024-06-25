package com.d_m.products.products.families.dtos;

import com.d_m.products.products.base.dtos.ProductResponse;

import java.util.List;

public record ProductFamilyResponse(String name, List<ProductResponse> products) {
}
