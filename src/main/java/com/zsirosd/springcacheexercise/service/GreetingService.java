package com.zsirosd.springcacheexercise.service;

import com.zsirosd.springcacheexercise.repository.NameRepository;
import com.zsirosd.springcacheexercise.response.GreetingResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final NameRepository nameRepository;

    public GreetingService(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    @Cacheable("getReversedGreetingOfName")
    public String getReversedName(String name) {
        return nameRepository.getReversedName(name);
    }

}
