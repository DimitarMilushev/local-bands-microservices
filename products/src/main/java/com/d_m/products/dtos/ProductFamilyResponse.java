package com.d_m.products.dtos;

import java.util.List;

public record ProductFamilyResponse(String name, List<ProductResponse> products) {
}
