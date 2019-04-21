package com.jfone.mall.base.entity.work.resp;

import io.swagger.annotations.ApiModelProperty;

/**
 *   商品列表返回参数
 *
 */

public class ShopListResp<T> {


    @ApiModelProperty("商品列表数据")
    private T data;


    public ShopListResp(T data){
        this.data = data;
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
