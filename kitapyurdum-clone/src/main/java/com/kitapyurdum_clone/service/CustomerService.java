package com.kitapyurdum_clone.service;

import com.kitapyurdum_clone.converter.CustomerConverter;
import com.kitapyurdum_clone.dto.request.CustomerSaveRequest;
import com.kitapyurdum_clone.exception.ExceptionMessage;
import com.kitapyurdum_clone.exception.KitapYurdumException;
import com.kitapyurdum_clone.model.Customer;
import com.kitapyurdum_clone.model.enums.AccountType;
import com.kitapyurdum_clone.repository.CustomerRepository;
import com.kitapyurdum_clone.util.HashUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository ;

    public void save(CustomerSaveRequest request) {

        Customer foundCostumer = getByEmail(request.getEmail());

        if (foundCostumer != null){
            log.info(ExceptionMessage.EMAIL_ALREADY_EXIST);
            throw new KitapYurdumException(ExceptionMessage.EMAIL_ALREADY_EXIST);
        }


        Customer customer = CustomerConverter.toCostumer(request);

        customerRepository.createCustomer(customer);
        log.info("Costumer created : " + customer.toString());


    }

    public List<Customer> getCustomerList()   {
        return customerRepository.getCustomerList();
    }

    public void changeAccountType(String email, AccountType accountType) {

        Optional<Customer> foundCustomer = getCustomerList()
                .stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst();

        if (foundCustomer.isPresent()) {
            foundCustomer.get().setAccountType(accountType);
        }
    }

    public Customer getById(Long id){

        Optional<Customer> foundedCostumer = customerRepository.findById(id);

        if(foundedCostumer.isEmpty()){
            throw new KitapYurdumException(ExceptionMessage.COSTUMER_NOT_FOUND );
        }
        return foundedCostumer.get();
    }

    public Customer getByEmail(String email){

        Optional<Customer> foundedCostumer = customerRepository.findByEmail(email);

        if(!foundedCostumer.get().getIsActive()){

            log.error(ExceptionMessage.COSTUMER_NOT_ACTIVE);

            throw new KitapYurdumException(ExceptionMessage.COSTUMER_NOT_ACTIVE);
        }


        return foundedCostumer.get();

    }

    public void changeAccountTypeByCredit(String email, AccountType accountType) {

    }


}
