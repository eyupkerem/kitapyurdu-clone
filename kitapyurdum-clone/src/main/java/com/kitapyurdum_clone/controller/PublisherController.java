package com.kitapyurdum_clone.controller;

import com.kitapyurdum_clone.dto.request.PublisherSaveRequest;
import com.kitapyurdum_clone.model.Publisher;
import com.kitapyurdum_clone.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody PublisherSaveRequest request){

        publisherService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping()
    public List<Publisher> getAll(){
        return publisherService.getAllPublishers();
    }
}
