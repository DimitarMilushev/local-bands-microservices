package com.d_m.products.controllers;

import com.d_m.products.dtos.CreateProductFamilyRequest;
import com.d_m.products.dtos.ProductFamilyResponse;
import com.d_m.products.dtos.ProductResponse;
import com.d_m.products.mappers.ProductFamilyMapper;
import com.d_m.products.mappers.ProductMapper;
import com.d_m.products.models.Product;
import com.d_m.products.models.ProductFamily;
import com.d_m.products.services.ProductFamilyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product-families")
@Validated
public class ProductFamilyController {
    private final ProductFamilyService productFamilyService;
    private final ProductMapper productMapper;
    private final ProductFamilyMapper productFamilyMapper;

    @GetMapping()
    public ResponseEntity<List<ProductFamilyResponse>> getAllProductFamilies() {
        List<ProductFamily> productFamilies = productFamilyService.getAllProductFamilies();
        List<ProductFamilyResponse> response = productFamilies.stream()
                .map(productFamilyMapper::productFamilyToProductFamilyResponse).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProductFamilyResponse> getProductFamilyById(@PathVariable Long id) {
        ProductFamily productFamily = productFamilyService.getProductFamilyById(id);
        ProductFamilyResponse response = productFamilyMapper.productFamilyToProductFamilyResponse(productFamily);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ProductFamilyResponse> getProductFamilyByName(@PathVariable String name) {
        ProductFamily productFamily = productFamilyService.getProductFamilyByName(name);
        ProductFamilyResponse response = productFamilyMapper.productFamilyToProductFamilyResponse(productFamily);
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<ProductFamilyResponse> createProductFamily(@RequestBody @Valid CreateProductFamilyRequest request) {
        ProductFamily productFamily = productFamilyService.createProductFamily(request);
        ProductFamilyResponse response = productFamilyMapper.productFamilyToProductFamilyResponse(productFamily);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/add-product/{productId}")
    public ResponseEntity<ProductFamilyResponse> addProductToFamily(@PathVariable Long id, @PathVariable Long productId) {
        ProductFamily productFamily = productFamilyService.addProductToFamily(id, productId);
        ProductFamilyResponse response = productFamilyMapper.productFamilyToProductFamilyResponse(productFamily);
        return ResponseEntity.ok(response);
    }
}
