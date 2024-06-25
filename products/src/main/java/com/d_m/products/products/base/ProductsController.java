package com.d_m.products.products.base;

import com.d_m.products.products.base.dtos.AddSizeVariationsRequest;
import com.d_m.products.products.base.dtos.CreateProductRequest;
import com.d_m.products.products.base.dtos.SingleProductViewResponse;
import com.d_m.products.products.base.mapper.ProductMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Validated
public class ProductsController {
    private final ProductsService service;
    private final ProductMapper mapper;
    @GetMapping("/all")
    public ResponseEntity<List<SingleProductViewResponse>> all() {
        List<Product> products = service.getAllApparels();
        List<SingleProductViewResponse> responses = new ArrayList<>();
        for (Product product : products) {
            SingleProductViewResponse response = mapper.productToSingleProductViewResponse(product);
            responses.add(response);
        }
        return ResponseEntity.ok(responses);
    }
    @GetMapping("id/{id}")
    public ResponseEntity<SingleProductViewResponse> getById(@Valid @PathVariable Long id) {
        final Product product = service.getProductById(id);
        SingleProductViewResponse response = mapper.productToSingleProductViewResponse(product);
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    public ResponseEntity<SingleProductViewResponse> create(@Valid @RequestBody CreateProductRequest payload) {
        final Product product = this.service.createApparelItem(payload);
        SingleProductViewResponse response = mapper.productToSingleProductViewResponse(product);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PatchMapping("add-sizes/{id}")
    public ResponseEntity<SingleProductViewResponse> addApparelVariations(
            @PathVariable Long id,
            @Valid @RequestBody AddSizeVariationsRequest request) {
        Product product = service.addProductVariations(request, id);
        SingleProductViewResponse response = mapper.productToSingleProductViewResponse(product);
        return ResponseEntity.ok(response);
    }
}
