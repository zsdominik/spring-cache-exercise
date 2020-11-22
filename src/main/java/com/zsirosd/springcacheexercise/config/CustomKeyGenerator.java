package com.zsirosd.springcacheexercise.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

public class CustomKeyGenerator implements KeyGenerator {

    Logger logger = LoggerFactory.getLogger(CustomKeyGenerator.class);

    @Override
    public Object generate(Object target, Method method, Object... params) {
        Object generatedKey = target.getClass().getSimpleName() + "_"
                + method.getName() + "_"
                + StringUtils.arrayToDelimitedString(params, "_")
                + "ABC";

        logger.info("Custom Cache Key Generated: " + generatedKey);
        return generatedKey;
    }
}
