package com.d_m.products.models;

import jakarta.persistence.*;

@Entity
@Table(name = "colors")
public class ColorsEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String hex;
}
