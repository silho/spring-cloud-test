package com.github.silho.cloudgateway.configuration;

import com.github.silho.cloudgateway.filters.AuthGlobalFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public GlobalFilter authGlobalFilter() {
        return new AuthGlobalFilter();
    }
}
