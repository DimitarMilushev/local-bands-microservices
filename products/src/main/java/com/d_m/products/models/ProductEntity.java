package com.d_m.products.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "products")
public class ProductEntity extends VersionedEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(length = 1024)
    private String description;

    @Column(nullable = false)
    private double price;

    //TODO: Maybe remove from here...
    @Column(columnDefinition = "text[]")
    private String[] images;
//    @PrimaryKeyJoinColumn()
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "details_id")
//    private ProductDetails details;
//    @Column()
//    @OneToOne(targetEntity = InventoryEntity.class, cascade = CascadeType.REMOVE)
//    private InventoryEntity inventory;
}
