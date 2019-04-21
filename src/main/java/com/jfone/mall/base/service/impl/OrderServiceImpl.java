package com.jfone.mall.base.service.impl;

import com.jfone.mall.base.entity.work.JfoneOrder;
import com.jfone.mall.base.entity.work.JfoneOrderItem;
import com.jfone.mall.base.entity.work.JfoneShipping;
import com.jfone.mall.base.mapping.work.JfoneOrderItemMapper;
import com.jfone.mall.base.mapping.work.JfoneOrderMapper;
import com.jfone.mall.base.mapping.work.JfoneShippingMapper;
import com.jfone.mall.base.pojo.JFResult;
import com.jfone.mall.base.service.OrderService;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    JfoneOrderMapper orderMapper;
    @Autowired
    JfoneOrderItemMapper orderItemMapper;
    @Autowired
    JfoneShippingMapper shippingMapper;

    @Override
    public JFResult creatOrder(JfoneOrder order,Integer orderShippingId, List<JfoneOrderItem> itemsList) {
        //向订单表中插入记录

        //获得订单号,使用commons.lang3包下的工具类生成随机数20位的订单号
        String numeric = RandomStringUtils.randomNumeric(10);
        Long orderId = Long.parseLong(numeric);
        //补全pojo属性
        order.setoOrderNo(orderId);
       // 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
        order.setoStatus(10);
        Date date = new Date();
        order.setoCreateTime(date);
        order.setoUpdateTime(date);
//        根据orderShippingId查询出下单的用户s_user_id

        Integer id = shippingMapper.selectByPrimaryKey(orderShippingId).getsUserId();

        order.setoUserId(id);
        order.setoShippingId(orderShippingId);


        //向订单表插入数据
        orderMapper.insert(order);


        //插入订单明细
        for (JfoneOrderItem orderItem:itemsList)
             {//补全订单明细表
                 //取订单明细ID,自增长，不需要设置
//                 Integer orderDetailId = Integer.parseInt(RandomStringUtils.randomNumeric(10));
//                 orderItem.setId(orderDetailId);
                 orderItem.setOiOrderNo(orderId);
                 orderItem.setOiUserId(id);
                 orderItemMapper.insert(orderItem);
        }

        //补全shipping


        //返回订单号
        JFResult result = new JFResult();

        result.setoOrderNo(orderId);

        return result;
    }

    @Override
    public List<JfoneOrder> findOrderListByUserId(Integer oUserId) {
        Example example = new Example(JfoneOrder.class);
        example.createCriteria().andEqualTo("oUserId", oUserId);
        List<JfoneOrder> list = orderMapper.selectByExample(example);


        return list;
    }

    @Override
    public List<JfoneOrderItem> findOrderItemByOrderNo(long oOrderNo) {
        Example example = new Example(JfoneOrderItem.class);
        example.createCriteria().andEqualTo("oiOrderNo", oOrderNo);
        List<JfoneOrderItem> list = orderItemMapper.selectByExample(example);
        return list;
    }
    @Override
    public JfoneShipping findShippingByoOrderNo (long oOrderNo){
        //根据订单号获取shippingId
        Example example1 = new Example(JfoneOrder.class);
        example1.createCriteria().andEqualTo("oOrderNo", oOrderNo);
        List<JfoneOrder> list = orderMapper.selectByExample(example1);
        if(list!=null&list.size()>0){
            JfoneOrder jfoneOrder = list.get(0);
            Integer shippingId = jfoneOrder.getoShippingId();
            //根据shippingId获取jfoneshipping
            Example  example2 = new Example(JfoneShipping.class);
            example2.createCriteria().andEqualTo("id", shippingId);
            List<JfoneShipping> jfoneShippings = shippingMapper.selectByExample(example2);
            if(jfoneShippings!=null&jfoneShippings.size()>0){
                JfoneShipping shipping = jfoneShippings.get(0);
                return shipping;
            }

        }
        return  null;
    }
}
