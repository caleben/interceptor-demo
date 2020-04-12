package com.javashitang.controller;

import com.javashitang.annotation.Authority;
import com.javashitang.common.ServerResponse;
import com.javashitang.pojo.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("login")
    public ServerResponse login(HttpSession session, String username) {
        session.setAttribute("username" ,username);
        return new ServerResponse(ServerResponse.GlobalStatus.SUCCESS);
    }

    @RequestMapping("shoppingCart")
    public ServerResponse shoppingCart() {
        Product product = new Product("产品名字", "产品描述");
        ServerResponse serverResponse = new ServerResponse(ServerResponse.GlobalStatus.SUCCESS);
        serverResponse.addObject(product);
        return serverResponse;
    }

    @Authority()
    @RequestMapping("delete")
    public ServerResponse delete(HttpServletRequest request) {
        String usename = (String) request.getAttribute("userInfo");
        log.info("{} delete the user", usename);
        return new ServerResponse(ServerResponse.GlobalStatus.SUCCESS,"删除用户备注");
    }
}
