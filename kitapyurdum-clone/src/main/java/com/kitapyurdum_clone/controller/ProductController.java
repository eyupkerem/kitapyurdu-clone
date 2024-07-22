package com.kitapyurdum_clone.controller;

import com.kitapyurdum_clone.dto.request.ProductSaveRequest;
import com.kitapyurdum_clone.dto.response.ProductResponse;
import com.kitapyurdum_clone.model.Product;
import com.kitapyurdum_clone.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody ProductSaveRequest request){
        productService.save(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Set<ProductResponse>> getAll(){
        return new ResponseEntity<>(productService.getAll()
                , HttpStatusCode.valueOf(HttpStatus.OK.value()));
    }
}
