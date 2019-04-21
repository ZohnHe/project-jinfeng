package com.jfone.mall.base.pojo;

import com.jfone.mall.base.entity.work.JfoneOrderItem;
import com.jfone.mall.base.entity.work.JfoneShipping;

import java.util.List;

/***
 * 这是查看订单详情的pojo
 */
public class CheckOrderDetail {
    private JfoneShipping jfoneShipping;
    private List<JfoneOrderItem> orderItemList;

    public JfoneShipping getJfoneShipping() {
        return jfoneShipping;
    }

    public void setJfoneShipping(JfoneShipping jfoneShipping) {
        this.jfoneShipping = jfoneShipping;
    }

    public List<JfoneOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<JfoneOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
