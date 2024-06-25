package com.d_m.products.products.base;

import com.d_m.products.categories.CategoryEntity;
import com.d_m.products.colors.ColorsEntity;
import com.d_m.products.common.VersionedEntity;
import com.d_m.products.genders.Gender;
import com.d_m.products.products.families.ProductFamily;
import com.d_m.products.products.variations.ProductsSizeVariation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "products")
public class Product extends VersionedEntity {
    @Column(nullable = false, length = 128)
    private String name;

    @Column(length = 1024)
    private String description;

    @Column(columnDefinition = "text[]")
    private String[] images;

    @ManyToOne()
    @JoinColumn(name = "category", referencedColumnName = "id")
    private CategoryEntity category;

    @ManyToOne()
    @JoinColumn(name = "color", referencedColumnName = "id")
    private ColorsEntity color;

    @ManyToOne()
    @JoinColumn(name = "gender", referencedColumnName = "id")
    private Gender gender;

    @OneToMany
    @JoinTable(
            name = "product_size_variations",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "variation_id")
    )
    private List<ProductsSizeVariation> availableSizes;

    @ManyToOne()
    @JoinColumn(name = "product_family", referencedColumnName = "id")
    private ProductFamily productFamily;
}
