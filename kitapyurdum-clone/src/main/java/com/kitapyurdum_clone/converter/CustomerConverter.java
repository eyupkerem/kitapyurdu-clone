package com.kitapyurdum_clone.converter;

import com.kitapyurdum_clone.dto.request.CustomerSaveRequest;
import com.kitapyurdum_clone.model.Customer;
import com.kitapyurdum_clone.util.HashUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerConverter {

    public static Customer toCostumer(CustomerSaveRequest request){

        String hashedPassword = HashUtil.generate(request.getPassword());

        return new Customer(request.getName()
                , request.getSurname()
                , request.getEmail()
                , hashedPassword);

    }


}
