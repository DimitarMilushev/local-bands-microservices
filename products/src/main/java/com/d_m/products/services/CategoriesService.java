package com.d_m.products.services;

import com.d_m.products.models.CategoryEntity;
import com.d_m.products.repositories.CategoriesRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriesService {
    private final CategoriesRepository repository;

    public CategoryEntity getById(Long id) {
        final Optional<CategoryEntity> result = this.repository.findById(id);
        if (result.isEmpty()) throw new EntityNotFoundException("Category with ID " + id + " doesn't exist");

        return result.get();
    }
}
