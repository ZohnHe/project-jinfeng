package com.jfone.mall.base.service;

import com.jfone.mall.base.domain.ShopCartEntity;
import com.jfone.mall.base.entity.work.JfoneCart;
import com.jfone.mall.base.entity.work.ext.JfoneShopCartProduct;

import java.util.List;

/**
 * com.jfone.mall.base.service
 * Author:lris DELL
 *
 * @Date:Created in 10:40 2019/2/20
 */
public interface ShopCartService {
    /**
     * 设定用户登录将购物车存放再数据库中
     * @param shopCartEntity 购物车前端传入实体
     * @return 操作返回int结果
     */
    Integer addShopCart(ShopCartEntity shopCartEntity);

    /**
     * 通过用户Id和商品Id 查询数据库中购物车对象
     * @param shopCartEntity
     * @return
     */
    JfoneCart getJfCartByUserId(ShopCartEntity shopCartEntity);

    /**
     * 添加购物车中商品数量
     * @param shopCartEntity
     * @param quantity
     * @return
     */
    Integer addQuantity(ShopCartEntity shopCartEntity,Integer quantity);

    /**
     * 通过用户id查询购物车
     * @param userId
     * @return
     */
    List<JfoneShopCartProduct> getListById(Integer userId);

    Integer deleteShopCartById(ShopCartEntity shopCartEntity);
}
