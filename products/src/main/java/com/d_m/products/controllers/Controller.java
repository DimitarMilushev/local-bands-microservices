package com.d_m.products.controllers;

import com.d_m.products.dtos.AddProductDto;
import com.d_m.products.models.ProductEntity;
import com.d_m.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class Controller {
    @Autowired
    private ProductService service;

    @PostMapping("/create")
    public ResponseEntity<String> createApparel(@RequestBody AddProductDto payload) {
        this.service.addOne(payload);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/all")
    public Collection<ProductEntity> all() {
        return this.service.getAll();
    }
}
