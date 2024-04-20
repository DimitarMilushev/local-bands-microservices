package com.d_m.products.repositories;

import com.d_m.products.models.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductsRepository extends CrudRepository<ProductEntity, Long> { }
