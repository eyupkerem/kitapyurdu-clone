package com.kitapyurdum_clone.model;

import com.kitapyurdum_clone.model.enums.OrderStatus;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private LocalDateTime createDate;
    private List<Product> productList;
    private String orderCode; //-ordercode generate
    private OrderStatus orderStatus;


}
