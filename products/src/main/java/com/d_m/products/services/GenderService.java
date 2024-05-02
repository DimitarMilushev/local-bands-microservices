package com.d_m.products.services;

import com.d_m.products.models.Gender;
import com.d_m.products.repositories.GenderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GenderService {
    private final GenderRepository genderRepository;

    public Gender getGenderById(Long id) {
        return genderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Gender not found"));
    }
}
