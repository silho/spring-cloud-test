package com.github.silho.zuulproxy.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@Component
public class PreFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(PreFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return Integer.MIN_VALUE;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("exec-time", System.nanoTime());
        String token = ctx.getRequest().getHeader("token");

        if (StringUtils.hasText(token)) {

            // 模拟鉴权失败
            if (System.currentTimeMillis() % 4 == 0) {
                logger.info("模拟鉴权失败");
                ctx.setResponseStatusCode(UNAUTHORIZED.value());
                ctx.setResponseBody("{\"code\":401,\"msg\":\"用户无权限\",\"obj\":null}");
                ctx.getResponse().setContentType(APPLICATION_JSON_UTF8.toString());
                ctx.setSendZuulResponse(false);
            }

            return null;
        } else {
            ctx.setResponseStatusCode(HttpStatus.SC_FORBIDDEN);
            ctx.setResponseBody("{\"code\":403,\"msg\":\"用户未登录\",\"obj\":null}");
            ctx.getResponse().setContentType(APPLICATION_JSON_UTF8.toString());
            ctx.setSendZuulResponse(false);
            return null;
        }
    }
}
