package com.d_m.products.repositories;

import com.d_m.products.models.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizesRepository extends JpaRepository<SizeEntity, Long> {
}
