package com.jfone.mall.base.service;

import com.github.pagehelper.PageInfo;
import com.jfone.mall.base.domain.GoodsQueryEntity;
import com.jfone.mall.base.entity.work.ext.JfoneWayOrder;
import com.jfone.mall.base.entity.work.JfoneInOutStorageInfo;
import com.jfone.mall.base.entity.work.ext.JfoneInOutStorageInfoExt;

import java.util.List;

/**
 * @Author:Chen.Q
 * @DATE:Created in 16:072019/2/19
 * @Remarks
 */
public interface IStorageService {
    public PageInfo<JfoneInOutStorageInfo> selectAll(GoodsQueryEntity goodsQueryEntity);
    public Integer addList(JfoneInOutStorageInfo jfoneInOutStorageInfo);
    public Integer delList(JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt);
    public Integer modifyList(JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt);
    public List<JfoneWayOrder> listByOrderId(JfoneWayOrder jfoneWayOrder);
    public Integer addId(JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt);
    public List<JfoneInOutStorageInfoExt> moveSel(JfoneInOutStorageInfoExt jfoneInOutStorageInfoExt);
}
