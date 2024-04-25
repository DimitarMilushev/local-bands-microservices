package com.d_m.products.controllers;

import com.d_m.products.dtos.CreateProductVarRequest;
import com.d_m.products.models.ProductVariationEntity;
import com.d_m.products.services.ProductVariationsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prod-vars")
@RequiredArgsConstructor
@Validated
public class ProductVariationsController {
    private final ProductVariationsService service;

    @GetMapping
    public ResponseEntity<List<ProductVariationEntity>> getAllProductVariations() {
        List<ProductVariationEntity> prodVars = service.getAllProductVars();
        return ResponseEntity.ok(prodVars);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProductVariationEntity> getProductVariationById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(service.getProductVarById(id));
    }

    @PostMapping()
    public ResponseEntity<ProductVariationEntity> createProductVariation(@Valid @RequestBody CreateProductVarRequest request) {
        return new ResponseEntity<>(service.createProductVariation(request), HttpStatus.CREATED);
    }
}
