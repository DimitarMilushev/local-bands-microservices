package com.d_m.products.mappers;

import com.d_m.products.dtos.AddProductDto;
import com.d_m.products.models.ProductEntity;

public class ProductsMapper {
    public ProductEntity fromAddProductDto(AddProductDto payload) {
        final var product = new ProductEntity();
        product.setName(payload.getName());
        product.setDescription(payload.getDescription());
        product.setSKU(payload.getSKU());
        product.setImages(payload.getImages());
        product.setPrice(payload.getPrice());
        product.setColorId(payload.getColorId());
        product.setCategoryId(payload.getCategoryId());
        product.setDiscountId(payload.getDiscountId());

        return product;
    }
}
