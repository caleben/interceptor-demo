package com.foryoutruck.conf;

import com.foryoutruck.common.ServerResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: lilimin
 * @Date: 2019/8/24 11:22
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        String username = (String) httpSession.getAttribute("username");
        if (username == null) {
            // 用户没有登录
            ServerResponse serverResponse = new ServerResponse(ServerResponse.GlobalStatus.ERROR, "请登录");
            ResponseWrite.writeResult(response, serverResponse);
            return false;
        } else {
            // 往request放一下用户的属性
            request.setAttribute("userInfo", username);
            return true;
        }
    }
}
