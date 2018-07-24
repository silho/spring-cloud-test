package com.github.silho.test.feign1.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.HashMap;

@FeignClient("spring-cloud-service1")
public interface SpringCloudService1 {

    @GetMapping("/info/getProfile")
    String getProfileInfo();

    @PostMapping("/example/header")
    HashMap testHeader(@RequestBody HashMap<String, Object> reqMap, @RequestHeader("X-Auth-Token") String token);
}