package com.d_m.products.repositories;

import com.d_m.products.models.ProductsSizeVariation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariationRepository extends JpaRepository<ProductsSizeVariation, Long> {
}
