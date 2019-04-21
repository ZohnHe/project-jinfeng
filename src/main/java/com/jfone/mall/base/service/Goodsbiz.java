package com.jfone.mall.base.service;

import com.github.pagehelper.PageInfo;
import com.jfone.mall.base.entity.work.dto.GoodsAddEntity;
import com.jfone.mall.base.entity.work.dto.GoodsModifyEntity;
import com.jfone.mall.base.entity.work.dto.GoodsQueryEntity;
import com.jfone.mall.base.entity.work.ext.PcGoodsInfo;


public interface Goodsbiz {
    PageInfo<PcGoodsInfo> getGoodsList(GoodsQueryEntity goodsQueryEntity);
    PageInfo<PcGoodsInfo> getGoodsFList(GoodsQueryEntity goodsQueryEntity);
    int goodsDelete(String[] goodsIds);
    int goodsAdd(GoodsAddEntity goodsAddEntity);
    int goodsModify(GoodsModifyEntity goodsModifyEntity);
    //int goodsFModify(GoodsModifyEntity goodsModifyEntity);
}
