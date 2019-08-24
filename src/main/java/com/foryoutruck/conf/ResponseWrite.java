package com.foryoutruck.conf;

import com.foryoutruck.common.ServerResponse;
import com.foryoutruck.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: lilimin
 * @Date: 2019/8/24 11:52
 */
@Slf4j
public class ResponseWrite {

    public static void writeResult(HttpServletResponse response, ServerResponse serverResponse) {
        try {
            response.reset();
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(JsonUtil.obj2String(serverResponse));
        } catch (Exception e) {
            log.error("http response write exception, result is: {}", JsonUtil.obj2String(serverResponse));
        }
    }
}
