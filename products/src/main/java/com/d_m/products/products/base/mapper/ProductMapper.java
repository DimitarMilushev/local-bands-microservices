package com.d_m.products.products.base.mapper;

import com.d_m.products.products.base.Product;
import com.d_m.products.products.base.dtos.ProductResponse;
import com.d_m.products.products.base.dtos.RelatedProductResponse;
import com.d_m.products.products.base.dtos.SingleProductViewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductResponse productToProductResponse(Product product);

    default SingleProductViewResponse productToSingleProductViewResponse(Product product) {
        if ( product == null ) {
            return null;
        }
        ProductResponse productResponse = INSTANCE.productToProductResponse(product);

        if ( product.getProductFamily() != null ) {
            List<RelatedProductResponse> relatedProducts = new ArrayList<RelatedProductResponse>();
            for (Product productFromFamily : product.getProductFamily().getProducts()) {
                relatedProducts.add(productToRelatedProductResponse(productFromFamily));
            }
            return new SingleProductViewResponse(productResponse, relatedProducts);
        } else {
            return new SingleProductViewResponse(productResponse, new ArrayList<RelatedProductResponse>());
        }

    }

    default RelatedProductResponse productToRelatedProductResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        return new RelatedProductResponse(
                product.getId(), product.getColor().getHex());
    }
}