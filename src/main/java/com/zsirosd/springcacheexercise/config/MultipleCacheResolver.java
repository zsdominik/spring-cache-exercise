package com.zsirosd.springcacheexercise.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;

import java.util.ArrayList;
import java.util.Collection;

public class MultipleCacheResolver implements CacheResolver {

    private final CacheManager defaultCacheManager;
    private final CacheManager caffeineCacheManager;

    private static final String METHOD_GET_REVERSED_NAME = "getReversedName";
    private static final String METHOD_GET_REVERSED_NAME_USING_CUSTOM_CACHE_KEY = "getReversedNameUsingCustomCacheKey";
    private static final String METHOD_GET_REVERSED_NAME_USING_CAFFEINE_CACHE_MANAGER = "getReversedNameUsingCaffeineCacheManager";

    public static final String GET_REVERSED_NAME_CACHE = "getReversedName";
    public static final String GET_REVERSED_NAME_CAFFEINE_CACHE = "getReversedNameCaffeine";
    public static final String CUSTOM_CACHE_RESOLVER = "customCacheResolver";
    public static final String CUSTOM_KEY_GENERATOR = "customKeyGenerator";

    public MultipleCacheResolver(CacheManager defaultCacheManager, CacheManager caffeineCacheManager) {
        this.defaultCacheManager = defaultCacheManager;
        this.caffeineCacheManager = caffeineCacheManager;
    }

    // we're selecting a cache manager based on the method name
    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        Collection<Cache> caches = new ArrayList<>();

        switch(context.getMethod().getName()) {
            case METHOD_GET_REVERSED_NAME_USING_CAFFEINE_CACHE_MANAGER:
                caches.add(caffeineCacheManager.getCache(GET_REVERSED_NAME_CAFFEINE_CACHE));
                break;
            case METHOD_GET_REVERSED_NAME:
            case METHOD_GET_REVERSED_NAME_USING_CUSTOM_CACHE_KEY:
            default:
                caches.add(defaultCacheManager.getCache(GET_REVERSED_NAME_CACHE));
                break;
        }

        return caches;
    }
}
