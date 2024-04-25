package com.d_m.products.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product_categories")
@Data
@NoArgsConstructor
@SuperBuilder
public class CategoryEntity extends VersionedEntity implements Serializable {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;
}
