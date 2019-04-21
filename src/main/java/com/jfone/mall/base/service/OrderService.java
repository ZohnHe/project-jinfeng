package com.jfone.mall.base.service;

import com.jfone.mall.base.entity.work.JfoneOrder;
import com.jfone.mall.base.entity.work.JfoneOrderItem;
import com.jfone.mall.base.entity.work.JfoneShipping;
import com.jfone.mall.base.pojo.JFResult;
import com.jfone.mall.base.pojo.Order;

import java.util.List;

public interface OrderService {
    JFResult creatOrder(JfoneOrder order, Integer orderShippingId, List<JfoneOrderItem> itemsList);
    List<JfoneOrder> findOrderListByUserId(Integer oUserId);
    List<JfoneOrderItem> findOrderItemByOrderNo(long oOrderNo);
    JfoneShipping findShippingByoOrderNo(long oOrderNo);
}
