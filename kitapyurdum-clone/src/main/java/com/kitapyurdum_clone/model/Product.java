package com.kitapyurdum_clone.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private String name;
    private BigDecimal amount;
    private String description;
    private Publisher publisher;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

}
