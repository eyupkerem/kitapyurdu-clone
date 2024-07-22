package com.kitapyurdum_clone.service;

import com.kitapyurdum_clone.model.Customer;
import com.kitapyurdum_clone.model.enums.AccountType;
import com.kitapyurdum_clone.repository.CustomerRepository;
import com.kitapyurdum_clone.util.HashUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository ;

    public void save(Customer customer) {
        customerRepository.createCustomer(customer);

        String hashedPassword = HashUtil.generate(customer.getPassword());

        customer.setPassword(hashedPassword);

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
            throw new RuntimeException("Costumer bulunamadı id :"+id);
        }
        return foundedCostumer.get();
    }

    public Customer getByEmail(String email){

        Optional<Customer> foundedCostumer = customerRepository.findByEmail(email);

        if(foundedCostumer.isEmpty()){
            throw new RuntimeException("Costumer bulunamadı email : "+ email);
        }

        if(!foundedCostumer.get().getIsActive()){
            throw new RuntimeException("Costumer aktif değil email : "+ email);
        }


        return foundedCostumer.get();

    }

    public void changeAccountTypeByCredit(String email, AccountType accountType) {

    }


}
