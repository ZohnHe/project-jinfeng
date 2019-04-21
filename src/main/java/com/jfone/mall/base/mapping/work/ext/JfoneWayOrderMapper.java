package com.jfone.mall.base.mapping.work.ext;

import com.jfone.mall.base.entity.work.ext.JfoneWayOrder;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author:Chen.Q
 * @DATE:Created in 20:372019/2/22
 * @Remarks
 */
public interface JfoneWayOrderMapper extends Mapper<JfoneWayOrder> {
    List<JfoneWayOrder> listByOrderId(JfoneWayOrder jfoneWayOrder);
}
