package com.jfone.mall.base.mapping.work;

import com.jfone.mall.base.entity.work.JfoneCoustomer;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface JfoneCoustomerMapper extends Mapper<JfoneCoustomer> {
    /* 解冻用户查询 */
    public List<JfoneCoustomer> CoustomerSearch(@Param("cUsername") String CoustomerName
            , @Param("orderStr") String orderStr); //param1/2

    /* 冻结用户查询 */
    public List<JfoneCoustomer> CoustomerFSearchUn(@Param("cUsername") String CoustomerName
            , @Param("orderStr") String orderStr); //param1/2


    /* 商品删除 */
    public Integer coustomerDelete(@Param("coustomerIds") String[] coustomerIds);
}