//package com.d_m.products.models;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Positive;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.io.Serializable;
//
//@Entity
//@Table(name = "product_inventory")
//@Getter @Setter @NoArgsConstructor
//public class InventoryEntity extends VersionedEntity implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    @Positive(message = "Quantity must be a positive number")
//    private int quantity;
//}
