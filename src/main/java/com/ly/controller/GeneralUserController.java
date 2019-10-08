package com.ly.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xinre
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class GeneralUserController {

    @RequestMapping("/login.page")
    public void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (StringUtils.isNotBlank(username)) {

        } else if (StringUtils.isNotBlank(password)) {

        }


    }
}
