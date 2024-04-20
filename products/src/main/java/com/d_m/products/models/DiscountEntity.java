package com.d_m.products.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "discounts")
@Getter @Setter @NoArgsConstructor
public class DiscountEntity extends VersionedEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private double percentage;

    @Column(nullable = false)
    private boolean active;
}
