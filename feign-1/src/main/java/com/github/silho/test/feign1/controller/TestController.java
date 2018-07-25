package com.github.silho.test.feign1.controller;

import com.github.silho.test.feign1.remote.SpringCloudService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private final String profile;
    private final SpringCloudService1 service1;

    @Autowired
    public TestController(@Value("${spring.profiles}") String profile, SpringCloudService1 service1) {
        this.profile = profile;
        this.service1 = service1;
    }

    @GetMapping("getInfo")
    public Object getInfo() {
        String profileInfo = service1.getProfileInfo();
        return profile + ":" + profileInfo;
    }

    @PostMapping("header")
    public Object testHeader(@RequestBody HashMap<String, Object> reqMap, @RequestHeader("X-Auth-Token") String token) {
        return service1.testHeader(reqMap, token);
    }
}
