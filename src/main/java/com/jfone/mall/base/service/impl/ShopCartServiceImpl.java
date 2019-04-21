package com.jfone.mall.base.service.impl;

import com.jfone.mall.base.domain.ShopCartEntity;
import com.jfone.mall.base.entity.work.JfoneCart;
import com.jfone.mall.base.entity.work.ext.JfoneShopCartProduct;
import com.jfone.mall.base.mapping.work.JfoneCartMapper;
import com.jfone.mall.base.mapping.work.ext.JfoneShopCartProductMapper;
import com.jfone.mall.base.service.ShopCartService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * com.jfone.mall.base.service.impl
 * Author:lris DELL
 *
 * @Date:Created in 10:40 2019/2/20
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Resource
    JfoneCartMapper jfoneCartMapper;

    @Resource
    JfoneShopCartProductMapper jfoneShopCartProductMapper;

    @Override
    public Integer addShopCart(ShopCartEntity shopCartEntity) {
        JfoneCart jfoneCart = new JfoneCart();
        BeanUtils.copyProperties(shopCartEntity,jfoneCart);
        jfoneCart.setcChecked(1);
        jfoneCart.setcCreateTime(new Date());
        jfoneCart.setcUpdateTime(new Date());
        int insert = jfoneCartMapper.insert(jfoneCart);
        if (insert>0){
            return  insert;
        }
        return 0;
    }

    @Override
    public JfoneCart getJfCartByUserId(ShopCartEntity shopCartEntity) {

        Example example = new Example(JfoneCart.class);
        example.createCriteria().andEqualTo("cUserId",shopCartEntity.getcUserId()).andEqualTo("cProductId",shopCartEntity.getcProductId());

        List<JfoneCart> jfoneCarts = jfoneCartMapper.selectByExample(example);
        if (jfoneCarts != null && jfoneCarts.size()>0){
            return jfoneCarts.get(0);
        }
        return null;
    }

    @Override
    public Integer addQuantity(ShopCartEntity shopCartEntity,Integer quantity) {
        Example example = new Example(JfoneCart.class);
        example.createCriteria().andEqualTo("cUserId",shopCartEntity.getcUserId()).andEqualTo
                ("cProductId",shopCartEntity.getcProductId());
        JfoneCart jfoneCart = new JfoneCart();
        jfoneCart.setcQuantity(quantity);
        int updataQuantity = jfoneCartMapper.updateByExampleSelective(jfoneCart, example);
        if (updataQuantity>0){
            return updataQuantity;
        }
        return 0;
    }

    @Override
    public List<JfoneShopCartProduct> getListById(Integer userId) {

        List<JfoneShopCartProduct> list = jfoneShopCartProductMapper.selectShopCartByUserId(userId);
        System.out.println(list);
        return list;
    }

    @Override
    public Integer deleteShopCartById(ShopCartEntity shopCartEntity) {
        Example example = new Example(JfoneCart.class);
        example.createCriteria().andEqualTo("id",shopCartEntity.getId()).andEqualTo("cUserId",shopCartEntity.getcUserId());
        int i = jfoneCartMapper.deleteByExample(example);
        if (i> 0){
            return i;
        }
        return 0;
    }
}
