package com.techrc.sso.mapper;


import com.techrc.sso.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public abstract interface UserMapper
{
   List<Map<String, Object>> findUserInfo();

    User findUserBySome();
    void addUser(User paramUser);

    User findByUsername(@Param("realName") String realName);

    User findUserByBNameAndPassword(@Param("realName") String realName, @Param("password") String password);
}


