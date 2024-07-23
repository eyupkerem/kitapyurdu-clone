package com.kitapyurdum_clone.service;

import com.kitapyurdum_clone.converter.ProductConverter;
import com.kitapyurdum_clone.dto.request.ProductSaveRequest;
import com.kitapyurdum_clone.dto.response.ProductResponse;
import com.kitapyurdum_clone.model.Product;
import com.kitapyurdum_clone.model.Publisher;
import com.kitapyurdum_clone.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository ;

    private final PublisherService publisherService;

    public void save(ProductSaveRequest request) {



        Optional<Publisher> publisher = publisherService.getByName(request.getPublisherName());

        if (publisher.isEmpty()) {

            log.info("publisher bulamadım : {}" + request.getPublisherName());

            throw new RuntimeException("publisher bulamadım");
        }

        Product product = ProductConverter.toProduct(request, publisher.get());

        productRepository.save(product);

        log.error("saved product : {}" + product.toString());
    }

    public Set<ProductResponse> getAll() {
        return  ProductConverter.toResponse( productRepository.getAll() ) ;
    }

}
