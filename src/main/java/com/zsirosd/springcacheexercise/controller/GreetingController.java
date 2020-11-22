package com.zsirosd.springcacheexercise.controller;

import com.zsirosd.springcacheexercise.repository.NameRepository;
import com.zsirosd.springcacheexercise.response.GreetingResponse;
import com.zsirosd.springcacheexercise.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public GreetingResponse getGreet(String name) {
        String reversedName = greetingService.getReversedName(name);
        GreetingResponse response = new GreetingResponse(reversedName, !NameRepository.isRepositoryCalled);
        NameRepository.isRepositoryCalled = false;
        return response;
    }

    @GetMapping("/greeting/custom-key")
    public GreetingResponse getGreetUsingCustomCacheKey(String name) {
        String reversedName = greetingService.getReversedNameUsingCustomCacheKey(name);
        GreetingResponse response = new GreetingResponse(reversedName, !NameRepository.isRepositoryCalled);
        NameRepository.isRepositoryCalled = false;
        return response;
    }
}
