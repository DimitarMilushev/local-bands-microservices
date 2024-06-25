package com.d_m.products.genders;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenderService {
    private final GenderRepository genderRepository;

    public Gender getGenderById(Long id) {
        return genderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Gender not found"));
    }
}
