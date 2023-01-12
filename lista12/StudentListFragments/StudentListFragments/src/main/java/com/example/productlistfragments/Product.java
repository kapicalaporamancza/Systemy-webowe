package com.example.productlistfragments;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    private long id;
    private String name;
    private Float weight;
    private Float price;
    private long category;
}
