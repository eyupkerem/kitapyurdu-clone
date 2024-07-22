package com.kitapyurdum_clone.repository;

import com.kitapyurdum_clone.model.Publisher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PublisherRepository {
    private List<Publisher> publishers = new ArrayList<>();

    public void save(Publisher publisher) {
        publishers.add(publisher);
    }

    public List<Publisher> findAll() {
        return publishers;
    }
}
