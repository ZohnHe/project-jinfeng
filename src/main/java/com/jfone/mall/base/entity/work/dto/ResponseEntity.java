package com.jfone.mall.base.entity.work.dto;

import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class ResponseEntity {

    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("成功状态：1=成功 0=失败")
    private String success;
    @ApiModelProperty("返回消息")
    private String msg;

    @Ignore
    private String userType;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
