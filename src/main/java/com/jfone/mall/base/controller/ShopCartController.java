package com.jfone.mall.base.controller;

import com.jfone.mall.base.domain.ShopCartEntity;
import com.jfone.mall.base.entity.work.JfoneCart;
import com.jfone.mall.base.entity.work.JfoneCoustomer;
import com.jfone.mall.base.entity.work.ext.JfoneShopCartProduct;
import com.jfone.mall.base.service.ShopCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * com.jfone.mall.base.controller
 * Author:lris DELL
 *
 * @Date:Created in 10:19 2019/2/20
 */
@Controller
@Api(tags="购物车模块")  //swagger分类标题注解
@RequestMapping(value = "/shopCart")
public class ShopCartController {

    @Resource
    ShopCartService shopCartService;

    @ApiOperation(value = "添加进购物车", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/addShopCart",method = RequestMethod.POST)
    @ResponseBody
    public Integer addShopCart(HttpServletRequest request,@RequestBody ShopCartEntity shopCartEntity){


        //先进行判断用户是否登录，登录存放再数据库中，没登录购物车对象存放再Cookie中
        JfoneCoustomer customer = (JfoneCoustomer) request.getSession().getAttribute("customer");



            shopCartEntity.setcUserId(21);
            //先根据用户Id和商品ID查询数据库，看购物车中是否存在该商品，存在值增加商品的数量，不存在创建购物车中的商品信息
            JfoneCart jfoneCart = shopCartService.getJfCartByUserId(shopCartEntity);
            //存在
            if (jfoneCart!= null){
                Integer quantity = jfoneCart.getcQuantity();
                Integer addQuantity = shopCartService.addQuantity(shopCartEntity,shopCartEntity.getcQuantity()+quantity);
                return  addQuantity;
            }
            //不存在
            else {
                Integer integer = shopCartService.addShopCart(shopCartEntity);
                if (integer > 0){
                    return integer;
                }
            }
            return 0;

    }

    @ApiOperation(value = "查询进购物车", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    @ResponseBody
    public List<JfoneShopCartProduct> getListShopCart(HttpServletRequest request){

        List<JfoneShopCartProduct> list = shopCartService.getListById(21);
        return list;
    }

    @ApiOperation(value = "删除进购物车", notes = "自定义请求头sessionId，sessionId的值是登陆接口返回的")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Integer deleteShopCart(@RequestBody ShopCartEntity shopCartEntity){

        shopCartEntity.setcUserId(21);
        Integer delete = shopCartService.deleteShopCartById(shopCartEntity);

        if (delete >0){
            return  delete;
        }
        return 0;
    }
}
