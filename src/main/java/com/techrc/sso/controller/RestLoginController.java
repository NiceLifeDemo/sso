package com.techrc.sso.controller;


import com.alibaba.fastjson.JSONObject;
import com.techrc.sso.dto.RestLoginDTO;
import com.techrc.sso.dto.RestRegistDTO;
import com.techrc.sso.model.User;
import com.techrc.sso.service.UserService;
import com.techrc.sso.util.Common;
import com.techrc.sso.util.PasswordHelper;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class RestLoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/toLogin")
    @ApiOperation(value="登录", tags={"用户"})
    public String ajaxLogin(@Valid @RequestBody RestLoginDTO userInfo) {
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUserName(), userInfo.getPassword());
        token.setRememberMe(true);
        try {
            subject.login(token);//===============>to UserRealm doGetAuthenticationInfo()
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            jsonObject.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }



    @PostMapping("/toRegist")
    @ApiOperation(value="注册", tags={"用户"})
    public String toRegist(@Valid @RequestBody RestRegistDTO userInfo) {
        JSONObject jsonObject = new JSONObject();
        User userRec = userService.findByUsername(userInfo.getRealName());
        if(Common.isNotEmpty(userRec)){
            jsonObject.put("msg","该用户已存在");
            return jsonObject.toString();
        }

        User user=new User();
        user.setRealName(userInfo.getRealName());
        user.setPassword(userInfo.getPassword());
        user.setPhoneNo(userInfo.getPhoneNo());
        user.setEmail(userInfo.getEmail());
        user.setTheme(userInfo.getTheme());
        user.setAvatar(userInfo.getAvatar());
        PasswordHelper passwordHelper=new PasswordHelper();
        passwordHelper.encryptPassword(user);

        try {
            userService.addUser(user);
            jsonObject.put("msg","注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("msg","注册失败");
        }
        return jsonObject.toString();
    }




}
