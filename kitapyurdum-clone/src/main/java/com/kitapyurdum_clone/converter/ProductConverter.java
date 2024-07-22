package com.kitapyurdum_clone.converter;

import com.kitapyurdum_clone.dto.request.ProductSaveRequest;
import com.kitapyurdum_clone.dto.response.ProductResponse;
import com.kitapyurdum_clone.model.Product;
import com.kitapyurdum_clone.model.Publisher;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class ProductConverter {
    public static Product toProduct(ProductSaveRequest request, Publisher publisher) {
        return Product.builder()
                .name(request.getName())
                .amount(request.getAmount())
                .description(request.getDescription())
                .publisher(publisher)
                .build();
    }

    public static ProductResponse toResponse(Product product) {

        return ProductResponse.builder()
                .amount(product.getAmount())
                .description(product.getDescription())
                .name(product.getName())
                .publisherName(product.getPublisher().getName())
                .build();

    }

    public static Set<ProductResponse> toResponse(Set<Product> products) {

        return products.stream()
                .map(ProductConverter::toResponse)
                .collect(Collectors.toSet());

    }
}
