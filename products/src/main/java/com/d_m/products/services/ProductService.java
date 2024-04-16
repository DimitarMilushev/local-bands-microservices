package com.d_m.products.services;

import com.d_m.products.dtos.AddProductDto;
import com.d_m.products.models.ProductEntity;
import com.d_m.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public void addOne(AddProductDto payload) {
        // TODO: Move to a mapper
        final var product = new ProductEntity();
        product.setName(payload.getName());
        product.setDescription(payload.getDescription());
        product.setImages(payload.getImages());
        product.setPrice(payload.getPrice());

        repository.save(product);
    }

    public Collection<ProductEntity> getAll() {
        final ArrayList<ProductEntity> products = new ArrayList<>();
        for (ProductEntity productEntity : repository.findAll()) {
            products.add(productEntity);
        }
        return products;
    }
}
