package com.jfone.mall.base.mapping.work.ext;

import com.jfone.mall.base.entity.work.ext.JfoneShopCartProduct;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * com.jfone.mall.base.mapping.work
 * Author:lris DELL
 *
 * @Date:Created in 12:14 2019/2/21
 */
public interface JfoneShopCartProductMapper extends Mapper<JfoneShopCartProduct> {
    List<JfoneShopCartProduct> selectShopCartByUserId(@Param("cUserId")Integer userId);
}
