package com.d_m.products.services;

import com.d_m.products.dtos.CreateProductVarRequest;
import com.d_m.products.models.ProductVariationEntity;
import com.d_m.products.models.SizeEntity;
import com.d_m.products.repositories.ProductVariationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductVariationsService {
    private final ProductVariationRepository repository;
    private final SizesService sizesService;
    private final DiscountsService discountsService;

    public List<ProductVariationEntity> getAllProductVars() {
        return repository.findAll();
    }
    public ProductVariationEntity createProductVariation(CreateProductVarRequest request) {
        SizeEntity size = sizesService.getSizeById(request.sizeId());
        ProductVariationEntity newProductVar = ProductVariationEntity.builder()
                .size(size)
                .price(request.price()).build();
        return repository.save(newProductVar);
    }

    public ProductVariationEntity getProductVarById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("ProductVar with id " + id + " not found" ));
    }

    public ProductVariationEntity addDiscount(Long productVarId, Long discountId) {
        ProductVariationEntity productVar = getProductVarById(productVarId);
        productVar.setDiscount(discountsService.getDiscountById(discountId));
        return repository.save(productVar);
    }
}
