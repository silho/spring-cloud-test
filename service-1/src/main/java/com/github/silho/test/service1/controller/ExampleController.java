package com.github.silho.test.service1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/example")
public class ExampleController {
    private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);

    @PostMapping("header")
    public HashMap header(@RequestBody HashMap<String, String> reqMap, HttpServletRequest request) {
        logger.debug("X-Auth-Token:{}", request.getHeader("X-Auth-Token"));
        logger.debug("请求参数:{}", reqMap);
        return reqMap;
    }
}
