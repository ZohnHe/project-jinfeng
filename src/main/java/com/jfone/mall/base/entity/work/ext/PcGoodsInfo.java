package com.jfone.mall.base.entity.work.ext;

import com.jfone.mall.base.entity.work.JfoneProduct;

import javax.persistence.Column;


public class PcGoodsInfo extends JfoneProduct {
    @Column(name = "goods_category")
    private String goodsCategory;

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }
}