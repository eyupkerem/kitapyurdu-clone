package com.kitapyurdum_clone.model;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book extends Product {

    private Author author;

    public Book(String name, BigDecimal amount, String description, Publisher publisher, Author author) {
        super(name, amount, description, publisher);
        this.author = author;
    }


}
