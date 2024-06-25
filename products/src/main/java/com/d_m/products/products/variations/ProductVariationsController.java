package com.d_m.products.products.variations;

import com.d_m.products.products.variations.dtos.CreateSizeVarRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/size-variations")
@RequiredArgsConstructor
@Validated
public class ProductVariationsController {
    private final ProductVariationsService service;

    @GetMapping
    public ResponseEntity<List<ProductsSizeVariation>> getAllProductVariations() {
        List<ProductsSizeVariation> prodVars = service.getAllProductVars();
        return ResponseEntity.ok(prodVars);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProductsSizeVariation> getProductVariationById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(service.getProductVarById(id));
    }

    @PostMapping()
    public ResponseEntity<ProductsSizeVariation> createProductVariation(@Valid @RequestBody CreateSizeVarRequest request) {
        return new ResponseEntity<>(service.createProductVariation(request), HttpStatus.CREATED);
    }
}
