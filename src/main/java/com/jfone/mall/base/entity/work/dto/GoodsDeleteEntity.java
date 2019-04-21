package com.jfone.mall.base.entity.work.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

/**
 *  商品列表请求输入参数
 *
 */

public class GoodsDeleteEntity {

    @ApiModelProperty("需要删除的商品ID列表")
    @Size(min=1,message="商品ID不能为空!")
    private String[] goodsIds;

    public String[] getGoodsIds() {
        return goodsIds;
    }
    public void setGoodsIds(String[] goodsIds) {
        this.goodsIds = goodsIds;
    }
}
