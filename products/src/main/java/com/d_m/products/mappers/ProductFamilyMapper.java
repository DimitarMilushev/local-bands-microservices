package com.d_m.products.mappers;

import com.d_m.products.dtos.ProductFamilyResponse;
import com.d_m.products.models.ProductFamily;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductFamilyMapper {
    ProductFamilyResponse productFamilyToProductFamilyResponse(ProductFamily productFamily);
}
