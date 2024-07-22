package com.kitapyurdum_clone.service;

import com.kitapyurdum_clone.converter.PublisherConverter;
import com.kitapyurdum_clone.dto.request.PublisherSaveRequest;
import com.kitapyurdum_clone.model.Publisher;
import com.kitapyurdum_clone.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublisherService {

    private final PublisherRepository publisherRepository ;

    public void save(PublisherSaveRequest request) {

        Publisher publisher = PublisherConverter.toPublisher(request);
        publisherRepository.save(publisher);
        log.info("Publisher saved {}",publisher.toString());

    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Optional<Publisher> getByName(String publisherName) {
        return getAllPublishers().stream()
                .filter(publisher -> publisher.getName().equals(publisherName))
                .findFirst();
    }

}
