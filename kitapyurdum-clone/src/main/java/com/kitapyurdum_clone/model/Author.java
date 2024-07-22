package com.kitapyurdum_clone.model;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    private String name;
    private String surname;
    private String bio;
    private Set<Book> books;

    public Author(String name, String surname, String bio) {
        this.name = name;
        this.surname = surname;
        this.bio = bio;
    }


}
