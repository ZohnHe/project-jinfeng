package com.jfone.mall.base.mapping.work.ext;

import com.jfone.mall.base.entity.work.JfoneProduct;
import com.jfone.mall.base.entity.work.ext.PcGoodsInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface JfoneProductMapperExt extends Mapper<JfoneProduct> {
    /* 商品搜索 */
    public List<PcGoodsInfo> goodsSearch(@Param("pName") String goodsName
            , @Param("orderStr") String orderStr); //param1/2
    /* 上架商品联合查询 */
    public List<PcGoodsInfo> goodsSearchUn(@Param("pName") String goodsName
            , @Param("orderStr") String orderStr); //param1/2
    /* 下架商品联合查询 */
    public List<PcGoodsInfo> goodsFSearchUn(@Param("pName") String goodsName
            , @Param("orderStr") String orderStr); //param1/2

    /* 前台商品查询 */
    public List<PcGoodsInfo> goodsList(); //param1/2

    /* 商品删除 */
    public Integer goodsDelete(@Param("goodsIds") String[] goodsIds);
}