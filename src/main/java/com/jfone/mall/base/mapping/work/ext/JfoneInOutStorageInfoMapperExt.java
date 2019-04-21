package com.jfone.mall.base.mapping.work.ext;

import com.jfone.mall.base.entity.work.ext.JfoneInOutStorageInfoExt;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface JfoneInOutStorageInfoMapperExt extends Mapper<JfoneInOutStorageInfoExt> {
    Integer delList(@Param("ids") Integer[] ids);
    Integer modifyList(JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt);
    Integer addId(JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt);
    List<JfoneInOutStorageInfoExt> moveSel(JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt);
}