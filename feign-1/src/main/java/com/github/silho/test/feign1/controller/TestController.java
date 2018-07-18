package com.github.silho.test.feign1.controller;

import com.github.silho.test.feign1.remote.SpringCloudService1;
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
    private final SpringCloudService1 service1;

    @Autowired
    public TestController(@Value("${spring.profiles}") String profile, SpringCloudService1 service1) {
        this.profile = profile;
        this.service1 = service1;
    }

    @GetMapping("getInfo")
    public Object getInfo() {
        long start = System.currentTimeMillis();
        String profileInfo = service1.getProfileInfo();
        long end = System.currentTimeMillis();
        logger.debug("接口调用耗时：{}", end - start);
        return profile + ":" + profileInfo;
    }
}
