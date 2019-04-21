package com.jfone.mall.base.service;

import com.github.pagehelper.PageInfo;
import com.jfone.mall.base.entity.work.dto.GoodsQueryEntity;
import com.jfone.mall.base.entity.work.ext.PcGoodsInfo;


public interface Shopbiz {
    PageInfo<PcGoodsInfo> getGoodsList(GoodsQueryEntity goodsQueryEntity);
}
