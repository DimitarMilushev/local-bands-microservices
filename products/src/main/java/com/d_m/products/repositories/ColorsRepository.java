package com.d_m.products.repositories;

import com.d_m.products.models.ColorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorsRepository extends JpaRepository<ColorsEntity, Long> {
}
