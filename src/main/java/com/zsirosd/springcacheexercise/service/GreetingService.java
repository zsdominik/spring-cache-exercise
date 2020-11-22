package com.zsirosd.springcacheexercise.service;

import com.zsirosd.springcacheexercise.repository.NameRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.zsirosd.springcacheexercise.config.MultipleCacheResolver.CUSTOM_CACHE_RESOLVER;
import static com.zsirosd.springcacheexercise.config.MultipleCacheResolver.CUSTOM_KEY_GENERATOR;
import static com.zsirosd.springcacheexercise.config.MultipleCacheResolver.GET_REVERSED_NAME_CACHE;
import static com.zsirosd.springcacheexercise.config.MultipleCacheResolver.GET_REVERSED_NAME_CAFFEINE_CACHE;

@Service
public class GreetingService {

    private final NameRepository nameRepository;

    public GreetingService(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    // The default implementation here is the SimpleKeyGenerator – which uses the method parameters provided to generate a key
    @Cacheable(value = GET_REVERSED_NAME_CACHE, cacheResolver = CUSTOM_CACHE_RESOLVER)
    public String getReversedName(String name) {
        return nameRepository.getReversedName(name);
    }

    // Using custom implementation as Key Generator
    @Cacheable(value = GET_REVERSED_NAME_CACHE, keyGenerator = CUSTOM_KEY_GENERATOR, cacheResolver = CUSTOM_CACHE_RESOLVER)
    public String getReversedNameUsingCustomCacheKey(String name) {
        return nameRepository.getReversedName(name);
    }

    // Using Caffeine Cache manager
    @Cacheable(value = GET_REVERSED_NAME_CAFFEINE_CACHE, cacheResolver = CUSTOM_CACHE_RESOLVER)
    public String getReversedNameUsingCaffeineCacheManager(String name) {
        return nameRepository.getReversedName(name);
    }

}
