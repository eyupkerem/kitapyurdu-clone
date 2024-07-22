package com.kitapyurdum_clone.dto.request;

import com.kitapyurdum_clone.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductSaveRequest {

    private String name;
    private BigDecimal amount;
    private String description;
    private String publisherName;

}
