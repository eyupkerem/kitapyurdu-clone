package com.kitapyurdum_clone.converter;

import com.kitapyurdum_clone.dto.request.PublisherSaveRequest;
import com.kitapyurdum_clone.model.Publisher;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PublisherConverter {

    /*
    public static Publisher toPublisher(PublisherSaveRequest request) {
        return Publisher.builder()
                .name(request.getName())
                .createDate(request.getCreateDate())
                .build();

    }
     */

    public static Publisher toPublisher(PublisherSaveRequest request) {
        System.out.println("Received createDate: " + request.getCreateDate());
        return Publisher.builder()
                .name(request.getName())
                .createDate(request.getCreateDate())
                .build();
    }

}
