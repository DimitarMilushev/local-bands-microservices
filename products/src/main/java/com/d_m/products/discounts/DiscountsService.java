package com.d_m.products.discounts;

import com.d_m.products.discounts.dtos.CreateDiscountRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountsService {
    private final DiscountRepository repository;

    public DiscountEntity createDiscount(CreateDiscountRequest request) {
        DiscountEntity discount = DiscountEntity.builder().name(request.name())
                .description(request.description())
                .percentage(request.percentage())
                .active(request.active()).build();
        return repository.save(discount);
    }

    public List<DiscountEntity> getAllDiscounts() {
        return repository.findAll();
    }

    public DiscountEntity getDiscountById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Discount with id " + id + " not found" ));
    }
}
