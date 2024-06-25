package com.d_m.products.sizes;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SizesService {
    private final SizesRepository repository;

    public SizeEntity getSizeById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Size with id " + id + " not found" ));
    }
}
