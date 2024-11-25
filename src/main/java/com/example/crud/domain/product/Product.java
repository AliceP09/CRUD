package com.example.crud.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Table(name="Product")
@Entity(name="Product")
@EqualsAndHashCode(of="id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer price_in_cents;

    private Boolean active;

    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
        this.active = true;
    }
}
