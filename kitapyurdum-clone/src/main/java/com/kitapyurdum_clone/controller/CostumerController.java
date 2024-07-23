package com.kitapyurdum_clone.controller;

import com.kitapyurdum_clone.constants.KitapYurduConstants;
import com.kitapyurdum_clone.dto.request.CustomerSaveRequest;
import com.kitapyurdum_clone.dto.response.GenericResponse;
import com.kitapyurdum_clone.model.Customer;
import com.kitapyurdum_clone.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/costumers")
public class CostumerController {

    private final CustomerService costumerService;

    @PostMapping("/save")
    public void save(@RequestBody CustomerSaveRequest request){
        costumerService.save(request);
    }

    @GetMapping
    public List<Customer> getAll(){
        return costumerService.getCustomerList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getById(@PathVariable Long id){

        Customer costumer = costumerService.getById(id);

        GenericResponse genericResponse = new GenericResponse();

        return genericResponse.buildSuccessResponse(costumer) ;

    }


    @GetMapping("/{email}")
    public Customer getByEmail(@PathVariable String email){
        return costumerService.getByEmail(email);
    }

}
