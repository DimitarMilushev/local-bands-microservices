package com.d_m.products.controllers;

import com.d_m.products.dtos.AddApparelVariationsRequest;
import com.d_m.products.dtos.CreateApparelRequest;
import com.d_m.products.models.ApparelEntityBase;
import com.d_m.products.services.ApparelsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apparels")
@RequiredArgsConstructor
@Validated
public class ApparelsController {
    private final ApparelsService service;
    @GetMapping("/all")
    public ResponseEntity<List<ApparelEntityBase>> all() {
        return ResponseEntity.ok(this.service.getAllApparels());
    }
    @GetMapping("id/{id}")
    public ResponseEntity<ApparelEntityBase> getById(@Valid @PathVariable Long id) {
    final ApparelEntityBase product = service.getApparelById(id);
        return ResponseEntity.ok(product);
    }
    @PostMapping()
    public ResponseEntity<ApparelEntityBase> create(@Valid @RequestBody CreateApparelRequest payload) {
        final ApparelEntityBase added = this.service.createApparelItem(payload);

        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ApparelEntityBase> addApparelVariations(
            @PathVariable Long id,
            @Valid @RequestBody AddApparelVariationsRequest request) {
        return ResponseEntity.ok(service.addProductVariations(request, id));
    }
}
