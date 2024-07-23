package com.kitapyurdum_clone.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


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
