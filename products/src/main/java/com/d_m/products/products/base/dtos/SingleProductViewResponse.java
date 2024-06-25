package com.d_m.products.products.base.dtos;

import java.util.List;

public record SingleProductViewResponse(ProductResponse product, List<RelatedProductResponse> relatedProducts) {
}
