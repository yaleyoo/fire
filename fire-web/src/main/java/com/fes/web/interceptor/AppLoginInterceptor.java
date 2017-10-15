package com.fes.web.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fes.common.annotation.Authorization;
import com.fes.common.constants.UserType;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.common.util.TokenManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by qigege on 2017/8/14.
 */
public class AppLoginInterceptor implements HandlerInterceptor {

    @Resource
    private TokenManager tokenManager;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)){
            return true;
        }

        Method method = ((HandlerMethod) handler).getMethod();
        if (method.getAnnotation(Authorization.class) == null){
            return true;
        }

        String token = httpServletRequest.getHeader("Authorization");
        UserType[] userTypes = method.getAnnotation(Authorization.class).authority();

        if (!tokenManager.verifyToken(token, userTypes, httpServletRequest)){
            SimpleHttpResult httpResult = new SimpleHttpResult(false, "illegal request!");
            httpServletResponse.setStatus(401);
            httpServletResponse.getWriter().write(JSON.toJSONString(httpResult));
            httpServletResponse.getWriter().flush();
            httpServletResponse.getWriter().close();
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
