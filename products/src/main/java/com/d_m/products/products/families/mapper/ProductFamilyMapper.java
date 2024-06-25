package com.d_m.products.products.families.mapper;

import com.d_m.products.products.families.ProductFamily;
import com.d_m.products.products.families.dtos.ProductFamilyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductFamilyMapper {
    ProductFamilyResponse productFamilyToProductFamilyResponse(ProductFamily productFamily);
}
