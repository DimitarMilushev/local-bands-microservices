package com.d_m.products.colors;

import com.d_m.products.common.VersionedEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "colors")
public class ColorsEntity extends VersionedEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String hex;

    @Column(nullable = false)
    private String code;
}
