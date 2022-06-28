package com.example.testovoe.service;

import com.example.testovoe.repository.MyRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {
    private final MyRepository repository;

    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    public void newwConnection(String client1, String client2) throws EmptyResultDataAccessException {
        repository.neww(client1, client2);
    }

    public List get() {
        return repository.get();
    }
    public List getMax() {
        return repository.getMax();
    }
    public List getMin() {
        return repository.getMin();
    }
    public List getAvg() {
        return repository.getAvg();
    }
}