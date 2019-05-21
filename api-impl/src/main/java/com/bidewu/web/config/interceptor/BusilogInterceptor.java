package com.bidewu.web.config.interceptor;

import com.bidewu.web.common.busilog.BusiLog;
import com.bidewu.web.common.utils.MD5Util;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BusilogInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BusiLog methodAnnotation = ((HandlerMethod) handler).getMethodAnnotation(BusiLog.class);
        if(methodAnnotation!=null){
            request.setAttribute("busitype",methodAnnotation.busitype());
            request.setAttribute("busicode",methodAnnotation.busitype() + "_" + MD5Util.compute(String.valueOf(System.currentTimeMillis())));
        }
        return true;
    }
}
