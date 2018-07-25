package com.github.silho.test.feign1.interceptors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("execution(public * com.github.silho.test.feign1.remote.*.*(..))")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long exec = System.currentTimeMillis() - start;
        logger.debug("执行方法:{}   执行时间:{}   执行结果:{}",
                joinPoint.getSignature(), exec, result);
        return result;
    }
}
