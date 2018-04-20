package com.techrc.sso.service;


import com.techrc.sso.mapper.UserMapper;
import com.techrc.sso.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


     public List<Map<String, Object>>  findUserInfo(){

         List<Map<String, Object>> users=userMapper.findUserInfo();
         return users;
     }

     public User findCurrentUser(){

         User user=userMapper.findUserBySome();
         return  user;


     };

     public void addUser(User user){
         userMapper.addUser(user);

     }


    public User findUserByBNameAndPassword(String realName,String password){

        User user=userMapper.findUserByBNameAndPassword(realName,password);
        return  user;
    };


}
