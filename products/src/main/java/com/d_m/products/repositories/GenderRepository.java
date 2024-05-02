package com.d_m.products.repositories;

import com.d_m.products.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {
}
