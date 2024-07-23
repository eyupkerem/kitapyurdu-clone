package com.kitapyurdum_clone.dto.response;

import com.kitapyurdum_clone.constants.KitapYurduConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {
    private String message;
    private LocalDateTime date;
    private HttpStatus httpStatus;
    private T data;


    public static ResponseEntity<GenericResponse> buildFailResponse(String message){
        return new ResponseEntity<>(GenericResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(message)
                .date(LocalDateTime.now())
                .build()
                , HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value())
        );
    }

    public ResponseEntity<GenericResponse> buildSuccessResponse(T data){
        return new ResponseEntity<>(GenericResponse.builder()
                .message(KitapYurduConstants.SUCCESS)
                .date(LocalDateTime.now())
                .build()
                , HttpStatusCode.valueOf(HttpStatus.OK.value())
        );
    }





}


