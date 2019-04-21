package com.jfone.mall.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;

import com.jfone.mall.base.entity.work.JfoneProduct;

import com.jfone.mall.base.entity.work.dto.GoodsAddEntity;
import com.jfone.mall.base.entity.work.dto.GoodsModifyEntity;
import com.jfone.mall.base.entity.work.dto.GoodsQueryEntity;
import com.jfone.mall.base.entity.work.ext.PcGoodsInfo;
import com.jfone.mall.base.mapping.work.JfoneProductMapper;
import com.jfone.mall.base.mapping.work.ext.JfoneProductMapperExt;
import com.jfone.mall.base.service.Goodsbiz;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsbiz")
public class GoodsBizImpl implements Goodsbiz {

    @Resource
    JfoneProductMapper jfoneProductMapper;

    @Resource
    JfoneProductMapperExt jfoneProductMapperExt;

    public PageInfo<PcGoodsInfo> getGoodsList(GoodsQueryEntity goodsQueryEntity) {
        PageHelper.startPage(goodsQueryEntity.getPageNum(),goodsQueryEntity.getPageSize());

        //Example + List<TbGoodsInfo> data = tbGoodsInfoMapper.selectAll();
        String orderStr = getOrderStr(goodsQueryEntity);

        List<PcGoodsInfo> data = jfoneProductMapperExt.goodsSearchUn(goodsQueryEntity.getSearch(),orderStr);
        System.out.println("data"+data);
        return new PageInfo<PcGoodsInfo>(data);

    }

    public PageInfo<PcGoodsInfo> getGoodsFList(GoodsQueryEntity goodsQueryEntity) {
        PageHelper.startPage(goodsQueryEntity.getPageNum(),goodsQueryEntity.getPageSize());

        //Example + List<TbGoodsInfo> data = tbGoodsInfoMapper.selectAll();
        String orderStr = getOrderStr(goodsQueryEntity);

        List<PcGoodsInfo> data = jfoneProductMapperExt.goodsFSearchUn(goodsQueryEntity.getSearch(),orderStr);
        System.out.println("data"+data);
        return new PageInfo<PcGoodsInfo>(data);

    }
    @RequiresPermissions("product:manage")
    public int goodsDelete(String[] goodsIds) {
        return jfoneProductMapperExt.goodsDelete(goodsIds);
    }

    @RequiresPermissions("product:manage")
    public int goodsAdd(GoodsAddEntity goodsAddEntity) {
        JfoneProduct jfoneProduct = new JfoneProduct();
        //goodsAddEntity.setpMainImage("123");
        goodsAddEntity.setpCategoryId(100004);

        BeanUtils.copyProperties(goodsAddEntity,jfoneProduct);
        jfoneProduct.setpStatus(1);
        /*jfoneProduct.setGoodsFatherid(8);
        jfoneProduct.setGoodsParentid(1);*/


        return  jfoneProductMapper.insert(jfoneProduct);
    }

    @RequiresPermissions("product:manage")
    public int goodsModify(GoodsModifyEntity goodsModifyEntity) {
        /* 查询条件的设置 */
        Example example = new Example(JfoneProduct.class);
        //example.createCriteria() 构建查询条件
        //createCriteria()查询器，where条件
        //andEqualTo每个查询条件项是什么，各个字段 id=goodsModifyEntity.getGoodsIdx()
        example.createCriteria().andEqualTo("id",goodsModifyEntity.getGoodsIdx());

        List<JfoneProduct> list = jfoneProductMapper.selectByExample(example);
        if( list != null && list.size() > 0){
            JfoneProduct jfoneProduct = list.get(0);
            BeanUtils.copyProperties(goodsModifyEntity,jfoneProduct);
            return  jfoneProductMapper.updateByExample(jfoneProduct,example);
        }
        return 0;
    }
    /*public int goodsFModify(GoodsModifyEntity goodsModifyEntity) {
        *//* 查询条件的设置 *//*
        Example example = new Example(JfoneProduct.class);
        //example.createCriteria() 构建查询条件
        //createCriteria()查询器，where条件
        //andEqualTo每个查询条件项是什么，各个字段 id=goodsModifyEntity.getGoodsIdx()
        example.createCriteria().andEqualTo("id",goodsModifyEntity.getGoodsIdx());

        List<JfoneProduct> list = jfoneProductMapper.selectByExample(example);
        if( list != null && list.size() > 0){
            JfoneProduct jfoneProduct = list.get(0);
            BeanUtils.copyProperties(goodsModifyEntity,jfoneProduct);
            return  jfoneProductMapper.updateByExample(jfoneProduct,example);
        }
        return 0;
    }*/


    private String getOrderStr(GoodsQueryEntity goodsQueryEntity){
        StringBuffer stringBuffer = new StringBuffer();
        if(!StringUtil.isEmpty(goodsQueryEntity.getOrder())) {
            String strs[] = {"id","p_name","p_price","p_stock","p_detail"};
            stringBuffer.append(" order by "+strs[Integer.parseInt(goodsQueryEntity.getOrder())]+" " + goodsQueryEntity.getDir());
        }
        return stringBuffer.toString();
    }
}
