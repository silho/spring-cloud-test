package com.github.silho.test.feign1.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoRequestInterceptor implements RequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(DemoRequestInterceptor.class);

    @Override
    public void apply(RequestTemplate template) {
        logger.debug("拦截器：{}", template);
    }
}
