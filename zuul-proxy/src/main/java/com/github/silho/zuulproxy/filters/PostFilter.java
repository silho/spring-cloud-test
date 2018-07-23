package com.github.silho.zuulproxy.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

@Component
public class PostFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(PostFilter.class);

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        long start = (long) ctx.get("exec-time");
        long exec = System.nanoTime() - start;
        logger.debug("请求完成：{} 执行时间：{}", ctx.getRequest().getRequestURI(), exec);
        return null;
    }
}
