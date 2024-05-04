package com.d_m.products.repositories;

import com.d_m.products.models.ProductFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductFamilyRepository extends JpaRepository<ProductFamily, Long> {
    Optional<ProductFamily> findProductFamilyByName(String name);
}
