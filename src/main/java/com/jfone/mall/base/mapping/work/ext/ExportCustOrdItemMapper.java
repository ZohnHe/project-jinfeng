package com.jfone.mall.base.mapping.work.ext;

import com.jfone.mall.base.entity.work.ext.ExportCustOrdItem;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ExportCustOrdItemMapper extends Mapper<ExportCustOrdItem> {

    List<ExportCustOrdItem> getexport();
}
