package com.zsirosd.springcacheexercise.repository;

import com.zsirosd.springcacheexercise.util.StringUtil;
import org.springframework.stereotype.Repository;

@Repository
public class NameRepository {

    public static boolean isRepositoryCalled = false;

    public String getReversedName(String name) {
        isRepositoryCalled = true;
        return longDatabaseCall(name);
    }

    private String longDatabaseCall(String name) {
        try {
            Thread.sleep(3000);
            return StringUtil.reverseString(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }
}
