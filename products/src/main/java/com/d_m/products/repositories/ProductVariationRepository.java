package com.d_m.products.repositories;

import com.d_m.products.models.ProductVariationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariationRepository extends JpaRepository<ProductVariationEntity, Long> {
}
