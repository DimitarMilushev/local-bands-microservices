package com.d_m.products.products.families;

import com.d_m.products.common.VersionedEntity;
import com.d_m.products.products.base.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "product-families")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductFamily extends VersionedEntity {
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "productFamily", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;
}
