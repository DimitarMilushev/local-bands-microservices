package com.d_m.products.services;

import com.d_m.products.dtos.AddApparelVariationsRequest;
import com.d_m.products.dtos.CreateApparelRequest;
import com.d_m.products.models.*;
import com.d_m.products.repositories.ApparelsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApparelsService {
    private final ApparelsRepository repository;
    private final ProductVariationsService prodVarService;
    private final ColorsService colorsService;
    private final CategoriesService categoriesService;

    public ApparelEntityBase createApparelItem(CreateApparelRequest request) {
        ColorsEntity color = colorsService.getColorById(request.colorId());
        CategoryEntity category = categoriesService.getById(request.categoryId());

        ApparelEntityBase apparel = ApparelEntityBase.builder()
                .color(color)
                .name(request.name())
                .SKU(request.SKU())
                .description(request.description())
                .images(request.imageUrls())
                .category(category).build();
        return repository.save(apparel);
    }

    public ApparelEntityBase getApparelById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Apparel with id " + id + " not found" ));
    }

    public ApparelEntityBase addProductVariations(AddApparelVariationsRequest request, Long apparelId) {
        ApparelEntityBase apparel = getApparelById(apparelId);
        List<ProductVariationEntity> prodVars = new ArrayList<>();
        for (Long id : request.ids()) {
            ProductVariationEntity prodVar = prodVarService.getProductVarById(id);
            prodVars.add(prodVar);
        }
        apparel.getVariations().addAll(prodVars);
        apparel.setModifiedAt(ZonedDateTime.now());
        return repository.save(apparel);
    }

    public List<ApparelEntityBase> getAllApparels() {
        return repository.findAll();
    }
}
