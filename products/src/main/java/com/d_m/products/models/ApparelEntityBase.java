package com.d_m.products.models;

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
@Table(name = "apparels")
public class ApparelEntityBase extends BaseProductEntity {
    @ManyToOne()
    @JoinColumn(name = "color", referencedColumnName = "id")
    private ColorsEntity color;

    @OneToMany
    @JoinTable(
            name = "apparel_variation",
            joinColumns = @JoinColumn(name = "apparel_id"),
            inverseJoinColumns = @JoinColumn(name = "variation_id")
    )
    private List<ProductVariationEntity> variations;
}
