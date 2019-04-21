package com.jfone.mall.base.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * com.jfone.mall.base.domain
 * Author:lris DELL
 *
 * @Date:Created in 10:23 2019/2/20
 */
public class ShopCartEntity {
    private int id;
    @ApiModelProperty("用户Id")
    private int cUserId;
    @ApiModelProperty("商品Id")
    private int cProductId;
    @ApiModelProperty("商品数量")
    private int cQuantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ShopCartEntity{" +
                "cUserId=" + cUserId +
                ", cProductId=" + cProductId +
                ", cQuantity=" + cQuantity +
                '}';
    }

    public int getcUserId() {
        return cUserId;
    }

    public void setcUserId(int cUserId) {
        this.cUserId = cUserId;
    }

    public int getcProductId() {
        return cProductId;
    }

    public void setcProductId(int cProductId) {
        this.cProductId = cProductId;
    }

    public int getcQuantity() {
        return cQuantity;
    }

    public void setcQuantity(int cQuantity) {
        this.cQuantity = cQuantity;
    }
}
