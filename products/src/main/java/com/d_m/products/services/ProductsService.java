package com.d_m.products.services;

import com.d_m.products.dtos.AddProductDto;
import com.d_m.products.mappers.ProductsMapper;
import com.d_m.products.models.ProductEntity;
import com.d_m.products.repositories.ProductsRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    private final ProductsRepository repository;
    private final ProductsMapper mapper;

    public ProductsService(ProductsRepository repository) {
        this.repository = repository;
        this.mapper = new ProductsMapper();
    }

    public ProductEntity add(AddProductDto payload) {
        final ProductEntity newProduct = this.mapper.fromAddProductDto(payload); 
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
