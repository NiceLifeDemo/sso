package com.techrc.sso.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


@ApiModel
public class User
  implements Serializable {
    @ApiModelProperty("姓名")
    private String realName;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("电话")
     private String phoneNo;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @ApiModelProperty("邮箱")

    private  String email;

    @ApiModelProperty("主题")
    private  String theme;

    @ApiModelProperty("头像")
    private  String avatar;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName()
  {
    return this.realName;
}

 public void setRealName(String realName) {
/* 26 */     this.realName = realName;
/*    */   }

 public String getPassword() {
/* 30 */     return this.password;
/*    */   }

 public void setPassword(String password) {
/* 34 */     this.password = password;
/*    */   }

 public String getPhoneNo() {
/* 38 */     return this.phoneNo;
/*    */   }

  public void setPhoneNo(String phoneNo) {
/* 42 */     this.phoneNo = phoneNo;
/*    */   }
}

