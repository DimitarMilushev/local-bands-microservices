package com.d_m.products.dtos;

import com.d_m.products.models.Product;

import java.util.List;
import java.util.Map;

public record SingleProductViewResponse(ProductResponse product, List<RelatedProductResponse> relatedProducts) {
}
