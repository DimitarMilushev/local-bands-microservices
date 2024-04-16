//package com.d_m.products.models;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.io.Serializable;
//
//@MappedSuperclass
//@Getter @Setter @NoArgsConstructor
//public abstract class ProductDetails implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(columnDefinition = "text[]")
//    private String[] images;
//}
