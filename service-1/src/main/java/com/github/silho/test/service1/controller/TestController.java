package com.github.silho.test.service1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private final String profile;

    @Autowired
    public TestController(@Value("${spring.profiles}") String profile) {
        this.profile = profile;
    }

    @GetMapping("getProfile")
    public String getProfile() {
        logger.debug("服务接口getProfile被调用");
        return profile;
    }
}
