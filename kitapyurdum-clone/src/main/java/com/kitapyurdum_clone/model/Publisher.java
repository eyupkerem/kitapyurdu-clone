package com.kitapyurdum_clone.model;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Publisher {

    private String name;
    private LocalDate createDate;

}
