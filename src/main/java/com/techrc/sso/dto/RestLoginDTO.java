package com.techrc.sso.dto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/20.
 */
@ApiModel
public class RestLoginDTO implements Serializable {

    @ApiModelProperty("账号")
    @JSONField(ordinal = 1)
    private String userName;

    @ApiModelProperty("密码")
    @JSONField(ordinal = 2)
    private String password;

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName) {
/* 25 */     this.userName = userName;
/*    */   }

    public String getPassword() {
/* 29 */     return this.password;
/*    */   }

    public void setPassword(String password) {
/* 33 */     this.password = password;
/*    */   }

}
