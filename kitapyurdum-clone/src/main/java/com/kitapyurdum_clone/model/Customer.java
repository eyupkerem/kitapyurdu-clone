package com.kitapyurdum_clone.model;

import com.kitapyurdum_clone.model.enums.AccountType;
import lombok.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Customer {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer credit;
    private String phoneNumber;
    private Set<Address> addresses;
    private Boolean isActive;
    private AccountType accountType;


    public Customer(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.isActive = true;
        this.accountType = AccountType.STANDARD;
    }


}
