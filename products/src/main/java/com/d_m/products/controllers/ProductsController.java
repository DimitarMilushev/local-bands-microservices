package com.d_m.products.controllers;

import java.net.URI;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.d_m.products.dtos.AddProductDto;
import com.d_m.products.models.ProductEntity;
import com.d_m.products.services.ProductsService;

@RestController
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService service;
    @PostMapping("/create")
    public ResponseEntity<URI> create(@RequestBody AddProductDto payload) {
        final ProductEntity added = this.service.add(payload);
        final URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(added.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<ProductEntity>> all() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getById(@PathVariable Long id) {
    final ProductEntity product = this.service.findById(id);
        return ResponseEntity.ok(product);
    }
}
