package com.techrc.sso.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/4/20.
 */

@RestController
@RequestMapping("/login")
public class AlertNoLoginController {

    @GetMapping("/noLogin")
    public String noLogin() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "未登录");

        return jsonObject.toString();
    }
}
