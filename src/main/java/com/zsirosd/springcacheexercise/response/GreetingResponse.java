package com.zsirosd.springcacheexercise.response;

public class GreetingResponse {
    String reversedName;
    Boolean isCachedValue;

    public GreetingResponse() {
    }

    public GreetingResponse(String reversedName, Boolean isCachedValue) {
        this.reversedName = reversedName;
        this.isCachedValue = isCachedValue;
    }

    public String getReversedName() {
        return reversedName;
    }

    public void setReversedName(String reversedName) {
        this.reversedName = reversedName;
    }

    public Boolean getCachedValue() {
        return isCachedValue;
    }

    public void setCachedValue(Boolean cachedValue) {
        isCachedValue = cachedValue;
    }
}
