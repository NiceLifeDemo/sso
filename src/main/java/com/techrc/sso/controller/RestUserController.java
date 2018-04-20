package com.techrc.sso.controller;


import com.techrc.sso.model.User;
import com.techrc.sso.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class RestUserController {

    @Autowired
    private UserService userService;

    @GetMapping({"/getUserInfo"})
    @ApiOperation(value="查询用户", tags={"用户"})
    public List<Map<String, Object>> getUserInfo()
    {
        List<Map<String, Object>>  users = userService.findUserInfo();
        return users;
    }


    @PostMapping({"/addUser"})
    @ApiOperation(value="新增用户", tags={"用户"})
    public String addUser(@Valid @RequestBody User user)
    {
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

        return "success";
    }


}
