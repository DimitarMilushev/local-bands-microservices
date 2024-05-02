package com.d_m.products.services;

import com.d_m.products.dtos.AddSizeVariationsRequest;
import com.d_m.products.dtos.CreateProductRequest;
import com.d_m.products.models.*;
import com.d_m.products.repositories.ProductsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository repository;
    private final ProductVariationsService prodVarService;
    private final ColorsService colorsService;
    private final CategoriesService categoriesService;
    private final GenderService genderService;

    public Product createApparelItem(CreateProductRequest request) {
        ColorsEntity color = colorsService.getColorById(request.colorId());
        CategoryEntity category = categoriesService.getById(request.categoryId());
        Gender gender = genderService.getGenderById(request.genderId());

        Product product = Product.builder()
                .color(color)
                .name(request.name())
                .images(request.imageUrls())
                .category(category)
                .gender(gender).build();
        return repository.save(product);
    }

    public Product getApparelById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Apparel with id " + id + " not found" ));
    }

    public Product addProductVariations(AddSizeVariationsRequest request, Long apparelId) {
        Product apparel = getApparelById(apparelId);
        List<ProductsSizeVariation> prodVars = new ArrayList<>();
        for (Long id : request.ids()) {
            ProductsSizeVariation prodVar = prodVarService.getProductVarById(id);
            prodVars.add(prodVar);
        }
        apparel.getAvailableSizes().addAll(prodVars);
        apparel.setModifiedAt(ZonedDateTime.now());
        return repository.save(apparel);
    }

    public List<Product> getAllApparels() {
        return repository.findAll();
    }
}
