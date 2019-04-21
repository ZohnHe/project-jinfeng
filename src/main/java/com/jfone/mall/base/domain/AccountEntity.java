package com.jfone.mall.base.domain;

import io.swagger.annotations.ApiModelProperty;

public class AccountEntity {
    @ApiModelProperty("用户名id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
