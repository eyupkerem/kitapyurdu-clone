package com.kitapyurdum_clone.dto.response;

import com.kitapyurdum_clone.model.Publisher;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {


    private String name;
    private BigDecimal amount;
    private String description;
    private String publisherName;

}
