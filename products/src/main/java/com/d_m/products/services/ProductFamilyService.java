package com.d_m.products.services;

import com.d_m.products.dtos.CreateProductFamilyRequest;
import com.d_m.products.models.Product;
import com.d_m.products.models.ProductFamily;
import com.d_m.products.repositories.ProductFamilyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductFamilyService {
    private final ProductFamilyRepository productFamilyRepository;
    private final ProductsService productsService;

    public ProductFamily getProductFamilyById(Long id) {
        return productFamilyRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException(String.format("Product family with id %s not found", id)));
    }

    public ProductFamily getProductFamilyByName(String name) {
        return productFamilyRepository.findProductFamilyByName(name)
               .orElseThrow(() -> new EntityNotFoundException(String.format("Product family with name %s not found", name)));
    }

    public ProductFamily createProductFamily(CreateProductFamilyRequest request) {
        ProductFamily productFamily = ProductFamily.builder().name(request.name()).build();
        productFamily.setProducts(productsService.getProductsByIds(request.ids(), productFamily));
        return productFamilyRepository.save(productFamily);
    }


    public ProductFamily addProductToFamily(Long familyId, Long productId) {
        ProductFamily productFamily = getProductFamilyById(familyId);
        Product product = productsService.getProductById(productId);
        productFamily.getProducts().add(product);
        return productFamilyRepository.save(productFamily);
    }

    public List<ProductFamily> getAllProductFamilies() {
        return productFamilyRepository.findAll();
    }
}
