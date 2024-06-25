package com.d_m.products.genders;

import com.d_m.products.common.VersionedEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "genders")
public class Gender extends VersionedEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;
}
