package com.jfone.mall.base.mapping.work;

import com.jfone.mall.base.entity.work.JfoneCart;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface JfoneCartMapper extends Mapper<JfoneCart> {
    List<JfoneCart> selectShopCartByUserId(@Param("cUserId")Integer userId);
}