package com.example.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    private final DataRepository repository;

    DataService(DataRepository repository) {
        this.repository = repository;
    }

    public void save(DataModel data) {
        repository.save(data);
    }
}
