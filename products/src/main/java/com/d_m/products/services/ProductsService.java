package com.d_m.products.services;

import com.d_m.products.dtos.AddProductDto;
import com.d_m.products.mappers.ProductMapper;
import com.d_m.products.models.ProductEntity;
import com.d_m.products.repositories.ProductsRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductsService {
    private final ProductsRepository repository;
    private final ProductMapper mapper;

    public ProductEntity add(AddProductDto payload) {
        if (repository.existsBySKU(payload.SKU())) {
            throw new EntityExistsException("Product with SKU " + payload.SKU() + " already exists");
        }
        final ProductEntity newProduct = this.mapper.addProductDtoToProductEntity(payload);
        return repository.save(newProduct);
    }

    public Iterable<ProductEntity> getAll() {
        return this.repository.findAll();
    }

    public ProductEntity findById(Long id) throws EntityNotFoundException {
        final Optional<ProductEntity> product = this.repository.findById(id);
        if (product.isEmpty()) throw new EntityNotFoundException("Failed to find product with ID " + id);

        return product.get();
    }
}
