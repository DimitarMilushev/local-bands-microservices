package com.d_m.products.mappers;

import com.d_m.products.dtos.ProductResponse;
import com.d_m.products.dtos.RelatedProductResponse;
import com.d_m.products.dtos.SingleProductViewResponse;
import com.d_m.products.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductResponse productToProductResponse(Product product);

    default SingleProductViewResponse productToSingleProductViewResponse(Product product) {
        List<RelatedProductResponse> relatedProducts = new ArrayList<RelatedProductResponse>();
        for (Product productFromFamily : product.getProductFamily().getProducts()) {
            relatedProducts.add(productToRelatedProductResponse(productFromFamily));
        }
        ProductResponse productResponse = INSTANCE.productToProductResponse(product);
        return new SingleProductViewResponse(productResponse, relatedProducts);
    }

    default RelatedProductResponse productToRelatedProductResponse(Product product) {
        return new RelatedProductResponse(
                product.getId(), product.getColor().getHex());
    }
}