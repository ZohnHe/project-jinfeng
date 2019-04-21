package com.jfone.mall.base.entity.work.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

/**
 *  商品列表请求输入参数
 *
 */

public class CoustomerDeleteEntity {

    @ApiModelProperty("需要删除的用户ID列表")
    @Size(min=1,message="用户ID不能为空!")
    private String[] coustomerIds;


    public String[] getCoustomerIds() {
        return coustomerIds;
    }

    public void setCoustomerIds(String[] coustomerIds) {
        this.coustomerIds = coustomerIds;
    }
}
