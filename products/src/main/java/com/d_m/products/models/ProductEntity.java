package com.d_m.products.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "products")
@SuperBuilder
public class ProductEntity extends VersionedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String SKU;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(length = 1024)
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(columnDefinition = "text[]")
    private String[] images;

    @Column(name = "color_id")
    /*
     * TODO: d_m_ in the future, we could use DDD to init events that would check the IDs
     * in the database. This would ensure data integrity and preserve the SOC by not
     * adding the ColorRepository in the ProductsService
    */
    private Long colorId;

    @Column(name = "category_id", nullable = false)
    /*
     * TODO: d_m_ in the future, we could use DDD to init events that would check the IDs
     * in the database. This would ensure data integrity and preserve the SOC by not
     * adding the CategoriesRepository in the ProductsService
    */
    private Long categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CategoryEntity category;


    @Column(name = "discount_id")
    /*
     * TODO: d_m_ in the future, we could use DDD to init events that would check the IDs
     * in the database. This would ensure data integrity and preserve the SOC by not
     * adding the DiscountsRepository in the ProductsService
    */
    private Long  discountId;
}
