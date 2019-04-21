package com.jfone.mall.base.controller;

import com.jfone.mall.base.entity.work.JfoneCoustomer;
import com.jfone.mall.base.entity.work.JfoneOrder;
import com.jfone.mall.base.entity.work.JfoneOrderItem;
import com.jfone.mall.base.entity.work.JfoneShipping;
import com.jfone.mall.base.pojo.CheckOrderDetail;
import com.jfone.mall.base.pojo.JFResult;
import com.jfone.mall.base.pojo.MyOrderShow;
import com.jfone.mall.base.pojo.Order;
import com.jfone.mall.base.service.OrderService;
import javassist.bytecode.stackmap.BasicBlock;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 订单controller
 */
@Controller
@RequestMapping(value="/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value="/create",method =RequestMethod.POST)
    @ResponseBody
    public JFResult createOrder(@RequestBody Order order) {



            JFResult result = orderService.creatOrder(order,order.getOrderShippingId(), order.getItemsList());

                if(result.getoOrderNo()>0){
                    result.setSuccess("1");
                    result.setTotal(order.getoPayment());
                }
                return result;
    }

    @RequestMapping("/findList")
    @ResponseBody
    public MyOrderShow findOrderList(HttpServletRequest request){

        JfoneCoustomer customer = (JfoneCoustomer) request.getSession().getAttribute("customer");
        //Integer id = customer.getId();
        Integer id = 13;
        List<JfoneOrder> list = orderService.findOrderListByUserId(id);

        if(list!=null&list.size()>0){
            //补全MyOrderShow
            JfoneOrder order = list.get((list.size() - 1));
            MyOrderShow orderShow = new MyOrderShow();
            orderShow.setoPayment(order.getoPayment());
            orderShow.setoCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getoCreateTime()));
            orderShow.setoOrderNo(order.getoOrderNo());
            //根据获取的orderNo查询收件人信息
            JfoneShipping jfoneShipping = orderService.findShippingByoOrderNo(order.getoOrderNo());
            String name = jfoneShipping.getsReceiverName();
            orderShow.setsReceiverName(name);

            return orderShow;
        }



        return null;
    }

    @RequestMapping(value = "/findOrderItem",method =RequestMethod.POST )
    @ResponseBody
    public CheckOrderDetail findOrderByOrderNo(@RequestParam() Long orderId){

        //根据获取的orderId调用service获取结果。
        List<JfoneOrderItem> orderItemByOrderNo = orderService.findOrderItemByOrderNo(orderId);
        JfoneShipping shippingByoOrderNo = orderService.findShippingByoOrderNo(orderId);
        //创建返回的CheckOrderDetail对象
        CheckOrderDetail checkOrderDetail = new CheckOrderDetail();
        checkOrderDetail.setJfoneShipping(shippingByoOrderNo);
        checkOrderDetail.setOrderItemList(orderItemByOrderNo);

        return checkOrderDetail;
    }

}
