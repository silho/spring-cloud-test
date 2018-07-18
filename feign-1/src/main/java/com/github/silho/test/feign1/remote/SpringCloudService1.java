package com.github.silho.test.feign1.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("spring-cloud-service1")
public interface SpringCloudService1 {

    @GetMapping("/info/getProfile")
    String getProfileInfo();
}