package com.kitapyurdum_clone.controller;

import com.kitapyurdum_clone.model.Customer;
import com.kitapyurdum_clone.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/costumers")
public class CostumerController {

    private final CustomerService costumerService;

    @PostMapping("/save")
    public void save(@RequestBody Customer customer){

        costumerService.save(customer);

    }

    @GetMapping
    public List<Customer> getAll(){
        return costumerService.getCustomerList();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id){
        return costumerService.getById(id);
    }


    @GetMapping("/{email}")
    public Customer getByEmail(@PathVariable String email){
        return costumerService.getByEmail(email);
    }

}
