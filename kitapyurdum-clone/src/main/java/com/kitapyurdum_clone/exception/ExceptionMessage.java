package com.kitapyurdum_clone.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessage {


    public static final String COSTUMER_NOT_FOUND = "COSTUMER BULUNAMADI ";
    public static final String COSTUMER_NOT_ACTIVE = "COSTUMER AKTİF DEĞİL";
    public static final String EMAIL_ALREADY_EXIST = "BU MAIL KAYITLI";
}
