package com.jfone.mall.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.jfone.mall.base.entity.work.dto.GoodsQueryEntity;
import com.jfone.mall.base.entity.work.ext.PcGoodsInfo;
import com.jfone.mall.base.mapping.work.JfoneProductMapper;
import com.jfone.mall.base.mapping.work.ext.JfoneProductMapperExt;
import com.jfone.mall.base.service.Shopbiz;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("shopbiz")
public class ShopBizImpl implements Shopbiz {
    @Resource
    JfoneProductMapper jfoneProductMapper;

    @Resource
    JfoneProductMapperExt jfoneProductMapperExt;


    public PageInfo<PcGoodsInfo> getGoodsList(GoodsQueryEntity goodsQueryEntity) {
        PageHelper.startPage(goodsQueryEntity.getPageNum(),goodsQueryEntity.getPageSize());

        //Example + List<TbGoodsInfo> data = tbGoodsInfoMapper.selectAll();

        List<PcGoodsInfo> data = jfoneProductMapperExt.goodsList();
        System.out.println("data"+data);
        return new PageInfo<PcGoodsInfo>(data);

    }
}
