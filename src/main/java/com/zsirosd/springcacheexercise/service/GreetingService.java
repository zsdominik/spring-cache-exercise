package com.zsirosd.springcacheexercise.service;

import com.zsirosd.springcacheexercise.repository.NameRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final NameRepository nameRepository;

    public GreetingService(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    // The default implementation here is the SimpleKeyGenerator – which uses the method parameters provided to generate a key
    @Cacheable("getReversedGreetingOfName")
    public String getReversedName(String name) {
        return nameRepository.getReversedName(name);
    }

    // Using custom implementation as Key Generator
    @Cacheable(value = "getReversedGreetingOfName", keyGenerator = "customKeyGenerator")
    public String getReversedNameUsingCustomCacheKey(String name) {
        return nameRepository.getReversedName(name);
    }

}
