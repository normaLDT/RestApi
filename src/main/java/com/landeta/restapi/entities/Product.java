package com.landeta.restapi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name="producto")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nombre")
    private String name;

    @Column(name="precio")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="id_fabricante", nullable = false)
    private Maker maker;
}
