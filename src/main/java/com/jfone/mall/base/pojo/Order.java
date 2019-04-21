package com.jfone.mall.base.pojo;

import com.jfone.mall.base.entity.work.JfoneOrder;
import com.jfone.mall.base.entity.work.JfoneOrderItem;
import com.jfone.mall.base.entity.work.JfoneShipping;

import java.util.List;

/**
 * 创建订单信息时的包装的pojo
 */
public class Order extends JfoneOrder {

    private Integer orderShippingId ;
    private List<JfoneOrderItem> itemsList;


    public Integer getOrderShippingId() {
        return orderShippingId;
    }

    public void setOrderShippingId(Integer orderShippingId) {
        this.orderShippingId = orderShippingId;
    }

    public List<JfoneOrderItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<JfoneOrderItem> itemsList) {
        this.itemsList = itemsList;
    }


}
