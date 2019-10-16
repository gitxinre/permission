package com.ly.controller;

import com.ly.common.Result;
import com.ly.entity.po.UserPO;
import com.ly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xinre
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login/{username}/{password}",method = RequestMethod.GET)
    public Result login(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password) {

        UserPO user = userService.login(username, password);
        return Result.success(user);
    }
}
