package com.d_m.products.models;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public abstract class BaseProductEntity extends VersionedEntity {
    @Column(nullable = false, unique = true)
    private String SKU;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(length = 1024)
    private String description;

    @Column(columnDefinition = "text[]")
    private String[] images;

    @ManyToOne()
    @JoinColumn(name = "category", referencedColumnName = "id")
    private CategoryEntity category;

}
