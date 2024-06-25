package com.d_m.products.products.variations;

import com.d_m.products.common.VersionedEntity;
import com.d_m.products.discounts.DiscountEntity;
import com.d_m.products.sizes.SizeEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "size-variations")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class ProductsSizeVariation extends VersionedEntity {
    @Column(nullable = false, unique = true)
    private String SKU;

    @ManyToOne
    @JoinColumn(name = "size", referencedColumnName = "id")
    private SizeEntity size;

    @Column(nullable = false)
    private double price;

    @ManyToOne()
    @JoinColumn(name = "discount", referencedColumnName = "id")
    private DiscountEntity discount;

    @Column
    private int quantityAvailable;
}