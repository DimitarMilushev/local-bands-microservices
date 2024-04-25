package com.d_m.products.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.*;
import java.io.Serializable;

@MappedSuperclass
@Data
@NoArgsConstructor
@SuperBuilder
public abstract class VersionedEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @Column(name = "modified_at")
    private ZonedDateTime modifiedAt;

    @Column(name = "deleted_at")
    private ZonedDateTime deletedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = ZonedDateTime.now();
    }
    @PostUpdate
    protected void onUpdate() {
        this.modifiedAt = ZonedDateTime.now();
    }
    @PostRemove
    protected void onDelete() {
        this.deletedAt = ZonedDateTime.now();
    }
}
