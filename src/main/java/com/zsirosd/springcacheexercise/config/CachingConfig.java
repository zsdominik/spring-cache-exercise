package com.zsirosd.springcacheexercise.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableCaching
public class CachingConfig {

    // By default, it uses ConcurrentHashMap as the underlying cache if we've not specified any other explicitly.
    //
    // Now, Spring Boot will use this as default for all the methods until we explicitly specify our secondaryCacheManager for a method
    @Bean
    @Primary
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    @Bean
    public CacheManager secondaryCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(200)
                .maximumSize(500));
        return cacheManager;
    }

    @Bean
    @Primary
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Bean("customKeyGenerator")
    public KeyGenerator customKeyGenerator() {
        return new CustomKeyGenerator();
    }

    @Bean
    public CacheResolver customCacheResolver() {
        return new MultipleCacheResolver(cacheManager(), secondaryCacheManager());
    }
}
