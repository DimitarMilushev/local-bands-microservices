package com.d_m.products.services;

import com.d_m.products.dtos.CreateSizeVarRequest;
import com.d_m.products.models.ProductsSizeVariation;
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

    public List<ProductsSizeVariation> getAllProductVars() {
        return repository.findAll();
    }

    public ProductsSizeVariation createProductVariation(CreateSizeVarRequest request) {
        SizeEntity size = sizesService.getSizeById(request.sizeId());

        ProductsSizeVariation sizeVar = ProductsSizeVariation.builder()
                .size(size)
                .description(request.description())
                .price(request.price()).build();
        String categoryCode = request.categoryCode();
        String colorCode = request.colorCode();
        String genderCode = request.genderCode();
        Long productId = request.productId();
        String sizeCode = size.getCode();

        String sku = String.format("%s-%s-%s-%s-%s",
                categoryCode,
                genderCode,
                colorCode,
                productId,
                sizeCode);

        sizeVar.setSKU(sku);
        return repository.save(sizeVar);
    }

    public ProductsSizeVariation getProductVarById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("ProductVar with id " + id + " not found" ));
    }

    public ProductsSizeVariation addDiscount(Long productVarId, Long discountId) {
        ProductsSizeVariation productVar = getProductVarById(productVarId);
        productVar.setDiscount(discountsService.getDiscountById(discountId));
        return repository.save(productVar);
    }
}
