package com.d_m.products.services;

import com.d_m.products.dtos.CreateColorRequest;
import com.d_m.products.models.ColorsEntity;
import com.d_m.products.repositories.ColorsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorsService {
    private final ColorsRepository repository;

    public List<ColorsEntity> getAllColors() {
        return repository.findAll();
    }

    public ColorsEntity getColorById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Color with id " + id + " not found" ));
    }

    public ColorsEntity createColor(CreateColorRequest request) {
        ColorsEntity color = ColorsEntity.builder().name(request.name()).hex(request.hex()).build();
        return repository.save(color);
    }
}
