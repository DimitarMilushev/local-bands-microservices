package com.d_m.products.categories;

import com.d_m.products.common.VersionedEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
