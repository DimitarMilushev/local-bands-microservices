package com.d_m.products.controllers;

import com.d_m.products.dtos.AddSizeVariationsRequest;
import com.d_m.products.dtos.CreateProductRequest;
import com.d_m.products.models.Product;
import com.d_m.products.services.ProductsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Validated
public class ProductsController {
    private final ProductsService service;
    @GetMapping("/all")
    public ResponseEntity<List<Product>> all() {
        return ResponseEntity.ok(this.service.getAllApparels());
    }
    @GetMapping("id/{id}")
    public ResponseEntity<Product> getById(@Valid @PathVariable Long id) {
    final Product product = service.getApparelById(id);
        return ResponseEntity.ok(product);
    }
    @PostMapping()
    public ResponseEntity<Product> create(@Valid @RequestBody CreateProductRequest payload) {
        final Product added = this.service.createApparelItem(payload);

        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Product> addApparelVariations(
            @PathVariable Long id,
            @Valid @RequestBody AddSizeVariationsRequest request) {
        return ResponseEntity.ok(service.addProductVariations(request, id));
    }
}
