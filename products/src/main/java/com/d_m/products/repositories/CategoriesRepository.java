package com.d_m.products.repositories;

import com.d_m.products.models.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends CrudRepository<CategoryEntity, Long> {
}
