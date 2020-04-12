package com.javashitang.conf;

import com.javashitang.annotation.Authority;
import com.javashitang.common.ServerResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author: lilimin
 * @Date: 2019/8/24 11:22
 */
@Component
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Authority authority = method.getAnnotation(Authority.class);
        if (authority == null) {
            // 如果注解为null, 说明不需要拦截, 直接放过
            return true;
        }
        // 这个是用户判断用户是否登录的时候设置进去的
        // 登录就会set，没有登录就不会set
        String username = (String) request.getAttribute("userInfo");
        if (username == null) {
            ServerResponse serverResponse = new ServerResponse(ServerResponse.GlobalStatus.ERROR, "请登录");
            ResponseWrite.writeResult(response, serverResponse);
            return false;
        }
        // 拿到被访问url所需要的权限
        // 再看用户是否有这个权限
        // 有就返回true，否则返回false
        int value = authority.id();
        return true;
    }
}
